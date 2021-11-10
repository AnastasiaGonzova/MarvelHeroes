package com.gonza.MarvelHeroes.services;

import com.gonza.MarvelHeroes.extra.URLImage;
import com.gonza.MarvelHeroes.repositories.URLImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLImageService {

    @Autowired
    private URLImageRepository imageRepository;

    URLImage putImageInformation(URLImage image){
        return imageRepository.saveAndFlush(image);
    }

    void deleteImageInformation(Long id){
        imageRepository.deleteById(id);
    }

    URLImage getImageByID(Long id){
        return imageRepository.findById(id).get();
    }

    URLImage updateImageInformation(Long id, URLImage image){
        URLImage updatedImage = this.getImageByID(id);

        updatedImage.setPath(image.getPath());
        updatedImage.setExtension(image.getExtension());

        this.putImageInformation(updatedImage);
        return updatedImage;

    }
}
