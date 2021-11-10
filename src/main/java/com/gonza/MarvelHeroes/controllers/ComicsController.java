package com.gonza.MarvelHeroes.controllers;

import com.gonza.MarvelHeroes.data.Comics;
import com.gonza.MarvelHeroes.data.Hero;
import com.gonza.MarvelHeroes.services.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel")
public class ComicsController{

    @Autowired
    private ComicsService comicsService;

    @GetMapping(value = "/comics")
    @ResponseBody
    public List<Comics> getAllComics(){
        return comicsService.getAllComics();
    }

    @GetMapping(value = "/comics/{id}")
    @ResponseBody
    public Comics getComicsByID(@PathVariable Long id){
        return comicsService.getComicsByID(id);
    }

    @GetMapping(value = "/comics/{id}/heroes")
    @ResponseBody
    public List<Hero> getHeroListByID(@PathVariable Long id){
        return comicsService.getHeroListforComicsByID(id);
    }

    @PostMapping(value = "/hero/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Comics> newProduct(@RequestBody Comics comics) {
        return ResponseEntity.ok().body(this.comicsService.putComicsInformation(comics));
    }

    @DeleteMapping(value = "/comics/delete/{id}")
    public void deleteComics(@PathVariable Long id){
        comicsService.deleteComicsInformation(id);
    }

    @PutMapping(value = "/comics/update/{id}")
    public ResponseEntity<Comics> updateComics(@PathVariable Long id, @RequestBody Comics comics){
        if(comics == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(this.comicsService.updateComicsInformation(id, comics));
        }
    }
}
