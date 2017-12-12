
package wad.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Kuva;
import wad.repository.KuvaRepository;
import wad.repository.UutisRepository;

@Controller
public class KuvaController {
    @Autowired
    private KuvaRepository kuvaRepository;
    @Autowired
    private UutisRepository uutisRepository;
    
    @GetMapping("/news/picture")
    public String elegantCode() {
        return "pictures";
    }
    
    @GetMapping(path = "/news/picture/{id}", produces = "image/*")
    @ResponseBody
    public byte[] get(@PathVariable Long id) {
        return kuvaRepository.getOne(id).getContent();
    }
    
    @PostMapping("/news/picture")
    public String save(@RequestParam("file") MultipartFile file, @RequestParam String otsikko) throws IOException {
        Kuva k = new Kuva();
        k.setContent(file.getBytes());
        k.setUutinen(uutisRepository.findByOtsikko(otsikko));
        
        kuvaRepository.save(k);
        uutisRepository.findByOtsikko(otsikko).setKuva(k);
        uutisRepository.flush();

        return "redirect:/news";
    }
    
    
}
