package com.gonza.MarvelHeroes.controllers;

import com.gonza.MarvelHeroes.data.Comics;
import com.gonza.MarvelHeroes.data.Hero;
import com.gonza.MarvelHeroes.extra.URLImage;
import com.gonza.MarvelHeroes.services.ComicsService;
import com.gonza.MarvelHeroes.services.HeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/marvel")
public class HeroController{

    @Autowired
    private HeroService heroService;

    @Autowired
    private ComicsService comicsService;

    @GetMapping(value = "/hero")
    public String getAllHeroes(Model model){
        List<Hero> heroes = heroService.getAllHeroes();
        model.addAttribute("number", heroes.size());
        model.addAttribute("heroes", heroes);
        return "listHeroes";
    }

    @GetMapping(value = "/hero/{id}")
    public String getHeroByID(@PathVariable Long id, Model model){
        Hero hero = heroService.getHeroByID(id);
        model.addAttribute("title", hero.getName());
        model.addAttribute("hero", hero);
        String path = hero.getImage().getPath();
        model.addAttribute("image", path);
        return "infoHero";
    }

    @GetMapping(value = "/hero/{id}/comics")
    public String getComicsListByID(@PathVariable Long id, Model model){
        List<Comics> comics = heroService.getComicsListforHeroByID(id);
        model.addAttribute("number", comics.size());
        model.addAttribute("comics", comics);
        return "listComicsOfHero";
    }

    @GetMapping(value = "/hero/add")
    public String getAddHeroForm(Model model){
        model.addAttribute("allComics", comicsService.getAllComics());
        return "addHero";
    }

    @PostMapping(value = "/hero/add")
    public String addHero(@RequestParam String name, @RequestParam String description, @RequestParam("file") MultipartFile file, Model model)  throws IOException  {
        URLImage image = URLImage.ImageProcessing(file);
        Hero hero = new Hero(name, description, image);
        this.heroService.putHeroInformation(hero);
        return "redirect:/marvel/hero";
    }

    @PostMapping(value = "/hero/{id}/delete")
    public String deleteHero(@PathVariable Long id, Model model){
        heroService.deleteHeroInformation(id);
        return "redirect:/marvel/hero";
    }

    @GetMapping(value = "/hero/{id}/update")
    public String getUpdateHeroForm(@PathVariable Long id, Model model){
        if(heroService.getHeroByID(id) == null){
            return "error404";
        } else {
            model.addAttribute("hero", heroService.getHeroByID(id));
            return "updateHero";
        }
    }

    @PostMapping(value = "/hero/{id}/update")
    public String updateHero(@PathVariable Long id, Model model, @RequestParam String name, @RequestParam String description, @RequestParam("file") MultipartFile file) throws IOException{
        if(heroService.getHeroByID(id) == null){
            return "error404";
        } else {
            URLImage image = URLImage.ImageProcessing(file);
            Hero hero = new Hero(name, description, image);
            this.heroService.updateHeroInformation(id, hero);
            return "redirect:/marvel/hero/{id}";
        }
    }
}
