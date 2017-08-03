package io.braxton.demo.Controller;

import io.braxton.demo.Model.Playlist;
import io.braxton.demo.Repository.PlaylistRepository;
import io.braxton.demo.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/createPlaylist")
    public String createPlaylist() {
        return "createPlaylist";
    }

    @RequestMapping(value = "/createPlaylist", method = RequestMethod.POST)
    public String createPlaylist(@RequestParam("title") String title,
                                 @RequestParam("owner") String owner,
                                 @RequestParam("order") int order){
        Playlist playlist = new Playlist();
        playlist.setTitle(title);
        playlist.setOwner(owner);
        playlist.setOrder(order);
        playlistRepo.save(playlist);
        return "redirect:/";
    }
}