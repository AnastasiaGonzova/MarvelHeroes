package com.gonza.MarvelHeroes.services;

import com.gonza.MarvelHeroes.data.Comics;
import com.gonza.MarvelHeroes.data.Hero;
import com.gonza.MarvelHeroes.repositories.ComicsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicsService {

    @Autowired
    private ComicsRepository comicsRepository;

    @Autowired
    private URLImageService imageService;

    public Comics putComicsInformation(Comics comics){
        imageService.putImageInformation(comics.getImage());
        return comicsRepository.saveAndFlush(comics);
    }

    public Comics getComicsByID(Long id){
        return comicsRepository.findById(id).get();
    }

    public List<Comics> getAllComics(){
        return comicsRepository.findAll();
    }

    public void deleteComicsInformation(Long id){
        imageService.deleteImageInformation(this.getComicsByID(id).getImage().getID());
        comicsRepository.deleteById(id);
    }

    public Comics updateComicsInformation(Long id, Comics comics) {
        Comics updatedComics = this.getComicsByID(id);

        updatedComics.setTitle(comics.getTitle());
        updatedComics.setDescription(comics.getDescription());
        updatedComics.setDigitalID(comics.getDigitalID());
        updatedComics.setPageCount(comics.getPageCount());
        if(this.getComicsByID(id).getImage()==null){
            updatedComics.setImage(imageService.putImageInformation(comics.getImage()));
        }
        else{
            if(comics.getImage() == null){
                updatedComics.setImage(imageService.updateImageInformation(this.getComicsByID(id).getImage().getID(), comics.getImage()));
            }
        }
         updatedComics.setHeroList(comics.getHeroList());

        comicsRepository.save(updatedComics);
        return updatedComics;

    }

    public List<Hero> getHeroListforComicsByID(Long id){
        return this.getComicsByID(id).getHeroList();
    }
}
