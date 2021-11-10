package com.gonza.MarvelHeroes.controllers;

import com.gonza.MarvelHeroes.data.Comics;
import com.gonza.MarvelHeroes.data.Hero;
import com.gonza.MarvelHeroes.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel")
public class HeroController{

    @Autowired
    private HeroService heroService;

    @GetMapping(value = "/hero")
    @ResponseBody
    public List<Hero> getAllHeroes(){
        return heroService.getAllHeroes();
    }

    @GetMapping(value = "/hero/{id}")
    @ResponseBody
    public Hero getHeroByID(@PathVariable Long id){
        return heroService.getHeroByID(id);
    }

    @GetMapping(value = "/hero/{id}/comics")
    @ResponseBody
    public List<Comics> getComicsListByID(@PathVariable Long id){
        return heroService.getComicsListforHeroByID(id);
    }

    @PostMapping(value = "/hero/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Hero> newProduct(@RequestBody Hero hero) {
        return ResponseEntity.ok().body(this.heroService.putHeroInformation(hero));
    }

    @DeleteMapping(value = "/hero/delete/{id}")
    public void deleteHero(@PathVariable Long id){
        heroService.deleteHeroInformation(id);
    }

    @PutMapping(value = "/hero/update/{id}")
    public ResponseEntity<Hero> updateHero(@PathVariable Long id, @RequestBody Hero hero){
        if(hero == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(this.heroService.updateHeroInformation(id, hero));
        }
    }
}
