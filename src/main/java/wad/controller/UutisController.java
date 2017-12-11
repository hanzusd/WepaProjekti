
package wad.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Kuva;
import wad.domain.Uutinen;
import wad.repository.KuvaRepository;
import wad.repository.UutisRepository;

@Controller
public class UutisController {
    
    @Autowired
    private UutisRepository uutisRepository;
    @Autowired
    private KuvaRepository kuvaRepository;
    
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
    public String lisaa(@RequestParam String otsikko, @RequestParam String ingressi, @RequestParam String leipateksti) {
        Uutinen uutinen = new Uutinen();
        
        uutinen.setIngressi(ingressi);
        uutinen.setOtsikko(otsikko);
        uutinen.setLeipateksti(leipateksti);
        
        uutisRepository.save(uutinen);
        return "redirect:/";
    }
    
}
