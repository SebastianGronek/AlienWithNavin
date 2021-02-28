package AlienWithNavin.api;

import AlienWithNavin.dao.AlienRepository;
import AlienWithNavin.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AlienController {
    @Autowired
    AlienRepository alienRepository;

    @PostMapping("/addAlien")
    public Alien addAlien(Alien alien) {
        alienRepository.save(alien);
        return alien;
    }

    @GetMapping("/aliens")
    public List<Alien> getAllAliens() {
      return alienRepository.findAll();
    }

    @GetMapping("/aliens/{id}")
    public Alien getAlienById(@PathVariable int id) {
        return alienRepository.getOne(id);
    }
}
