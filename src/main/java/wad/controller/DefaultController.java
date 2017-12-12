package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wad.domain.Kategoria;
import wad.repository.KategoriaRepository;
import wad.repository.UutisRepository;

@Controller
public class DefaultController {
    @Autowired
    private UutisRepository uutisRepository;
    @Autowired
    private KategoriaRepository kategoriaRepository;

    @GetMapping("/")
    public String list(Model model) {
        PageRequest pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "date");
        PageRequest pg = PageRequest.of(0,5, Sort.Direction.DESC, "luettu");
        model.addAttribute("uutine", uutisRepository.findAll(pageable));
        model.addAttribute("utise", uutisRepository.findAll(pg));
        return "index";
    }
    
    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("uutine", uutisRepository.findAll());
        return "index";
    }
    
    
}
