package io.braxton.demo.Controller;

import io.braxton.demo.Model.Playlist;
import io.braxton.demo.Repository.PlaylistRepository;
import io.braxton.demo.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    PlaylistRepository playlistRepo;

    @Autowired
    SongRepository songRepo;


    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Playlist> lists = playlistRepo.findAll();
        model.addAttribute("lists", lists);
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}