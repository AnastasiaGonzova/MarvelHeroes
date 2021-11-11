package com.gonza.MarvelHeroes.services;

import com.gonza.MarvelHeroes.data.Comics;
import com.gonza.MarvelHeroes.data.Hero;
import com.gonza.MarvelHeroes.repositories.HeroRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private URLImageService imageService;

    public Hero putHeroInformation(Hero hero){
        return heroRepository.saveAndFlush(hero);
    }

    public List<Hero> putHeroesInformation(List<Hero> heroes){
        return heroRepository.saveAllAndFlush(heroes);
    }

    public Hero getHeroByID(Long id){
        return heroRepository.findById(id).get();
    }

    public List<Hero> getAllHeroes(){
        return heroRepository.findAll();
    }

    public void deleteHeroInformation(Long id){
        heroRepository.deleteById(id);
    }

    public Hero updateHeroInformation(Long id, Hero hero) {
        Hero updatedHero = this.getHeroByID(id);

        updatedHero.setName(hero.getName());
        updatedHero.setDescription(hero.getDescription());
        if(this.getHeroByID(id).getImage()==null) {
            updatedHero.setImage(imageService.putImageInformation(hero.getImage()));
        }
        else {
            updatedHero.setImage(imageService.updateImageInformation(this.getHeroByID(id).getImage().getID(), hero.getImage()));
        }
        updatedHero.setComicsList(hero.getComicsList());

        this.putHeroInformation(updatedHero);
        return updatedHero;

    }

    public List<Comics> getComicsListforHeroByID(Long id){
        return this.getHeroByID(id).getComicsList();
    }
}
