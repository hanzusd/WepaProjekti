
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Uutinen;
import wad.repository.UutisRepository;

@Controller
public class UutisController {
    
    @Autowired
    private UutisRepository uutisRepository;
    
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String nesw() {
        return "news";
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
