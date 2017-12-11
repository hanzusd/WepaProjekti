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
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Kategoria;
import wad.domain.Kuva;
import wad.domain.Uutinen;
import wad.repository.KategoriaRepository;
import wad.repository.UutisRepository;

@Controller
public class UutisController {

    @Autowired
    private UutisRepository uutisRepository;
    @Autowired
    private KategoriaRepository kategoriaRepository;

    @GetMapping("/news")
    public String nesw() {
        return "news";
    }

    @GetMapping("/news/{id}")
    public String yksiUutinen(Model model, @PathVariable Long id) {
        model.addAttribute("news", uutisRepository.findById(id).get());
        return "newspiece";
    }

    @PostMapping(value = "/news")
    public String lisaa(@RequestParam String otsikko, @RequestParam String ingressi, @RequestParam String leipateksti,
            @RequestParam("features") String[] features) {
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
        uutisRepository.save(uutinen);
        return "redirect:/";
    }
}
