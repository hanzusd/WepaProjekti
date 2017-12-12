package wad.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Kategoria;
import wad.domain.Kirjoittaja;
import wad.domain.Uutinen;
import wad.repository.KategoriaRepository;
import wad.repository.KirjoittajaRepository;
import wad.repository.UutisRepository;

@Controller
public class UutisController {

    @Autowired
    private UutisRepository uutisRepository;
    @Autowired
    private KategoriaRepository kategoriaRepository;
    @Autowired
    private KirjoittajaRepository kirjoittajaRepository;

    @GetMapping("/news")
    public String nesw() {
        return "news";
    }

    @GetMapping("/news/{id}")
    public String yksiUutinen(Model model, @PathVariable Long id) {
        model.addAttribute("news", uutisRepository.findById(id).get());
        uutisRepository.findById(id).get().kasvataLuettu();
        uutisRepository.flush();
        return "newspiece";
    }
    
    @GetMapping("news/kategoria/{kategoria}")
    public String uutisetKategorioittain(Model model, @PathVariable("kategoria") String kategoriaNimi) {
        if(!(kategoriaRepository.findByNimi(kategoriaNimi).getUutiset() == null)) {
        model.addAttribute("uutine", kategoriaRepository.findByNimi(kategoriaNimi).getUutiset());
        } else {
            model.addAttribute("viesti", "Ei kategorian uutisia");
            return "redirect:/";
        }
        return "index";
    }

    @PostMapping(value = "/news")
    public String lisaa(@RequestParam String otsikko, @RequestParam String ingressi, @RequestParam String leipateksti,
            @RequestParam("features") String[] features, @RequestParam("kirjoittaja") String[] kirjoittajat) {
        Uutinen uutinen = new Uutinen();
        uutinen.setIngressi(ingressi);
        uutinen.setOtsikko(otsikko);
        uutinen.setLeipateksti(leipateksti);

        for (int i = 0; i < features.length; i++) {
            if (kategoriaRepository.findByNimi(features[i]) == null) {
                Kategoria kategoria = new Kategoria(features[i]);
                kategoriaRepository.save(kategoria);
            }
            kategoriaRepository.findByNimi(features[i]).addUutinen(uutinen);
            uutinen.addKategoria(kategoriaRepository.findByNimi(features[i]));
            kategoriaRepository.flush();
        }
        for (int i = 0; i < kirjoittajat.length; i++) {
            if (kirjoittajaRepository.findByNimi(kirjoittajat[i]) == null) {
                Kirjoittaja kirjoittaja = new Kirjoittaja(kirjoittajat[i]);
                kirjoittajaRepository.save(kirjoittaja);
            }
            kirjoittajaRepository.findByNimi(kirjoittajat[i]).addUutinen(uutinen);
            uutinen.addKirjoittaja(kirjoittajaRepository.findByNimi(kirjoittajat[i]));
            kirjoittajaRepository.flush();
        }
        uutisRepository.save(uutinen);
        
        return "redirect:/";
    }
}
