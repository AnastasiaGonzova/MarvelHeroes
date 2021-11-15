package com.gonza.MarvelHeroes.controllers;

import com.gonza.MarvelHeroes.data.Comics;
import com.gonza.MarvelHeroes.data.Hero;
import com.gonza.MarvelHeroes.extra.URLImage;
import com.gonza.MarvelHeroes.services.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/marvel")
public class ComicsController{

    @Autowired
    private ComicsService comicsService;

    @GetMapping(value = "/comics")
    public String getAllComics(Model model){
        List<Comics> comics = comicsService.getAllComics();
        model.addAttribute("number", comics.size());
        model.addAttribute("allComics", comics);
        return "listComics";
    }

    @GetMapping(value = "/comics/{id}")
    public String getComicsByID(@PathVariable Long id, Model model){
        Comics comics = comicsService.getComicsByID(id);
        model.addAttribute("title", comics.getTitle());
        model.addAttribute("comics", comics);
        String path = comics.getImage().getPath();
        model.addAttribute("image", path);
        return "infoComics";
    }

    @GetMapping(value = "/comics/{id}/heroes")
    public String getComicsListByID(@PathVariable Long id, Model model){
        List<Hero> hero = comicsService.getHeroListforComicsByID(id);
        model.addAttribute("number", hero.size());
        model.addAttribute("heroes", hero);
        return "listHeroOfComics";
    }

    @GetMapping(value = "/comics/add")
    public String getAddComicsForm(Model model){
        return "addComics";
    }

    @PostMapping(value = "/comics/add")
    public String addComics(@RequestParam String title, @RequestParam String description, @RequestParam Long digitalID, @RequestParam int pageCount, @RequestParam("file") MultipartFile file, Model model)  throws IOException {
        URLImage image = URLImage.ImageProcessing(file);
        Comics comics = new Comics(digitalID, title, description, pageCount, image);
        this.comicsService.putComicsInformation(comics);
        return "redirect:/marvel/comics";
    }

    @PostMapping(value = "/comics/{id}/delete")
    public String deleteComics(@PathVariable Long id){
        comicsService.deleteComicsInformation(id);
        return "redirect:/marvel/comics";
    }

    @GetMapping(value = "/comics/{id}/update")
    public String getUpdateComicsForm(@PathVariable Long id, Model model){
        if(comicsService.getComicsByID(id) == null){
            return "error404";
        } else {
            model.addAttribute("hero", comicsService.getComicsByID(id));
            return "updateComics";
        }
    }


    @PostMapping(value = "/comics/{id}/update")
    public String updateComics(@PathVariable Long id, Model model, @RequestParam String title, @RequestParam String description, @RequestParam Long digitalID, @RequestParam int pageCount, @RequestParam("file") MultipartFile file) throws IOException{
        if(comicsService.getComicsByID(id) == null){
            return "error404";
        } else {
            URLImage image = URLImage.ImageProcessing(file);
            Comics comics = new Comics(digitalID, title, description, pageCount, image);
            this.comicsService.updateComicsInformation(id, comics);
            return "redirect:/marvel/comics/{id}";
        }
    }
}
