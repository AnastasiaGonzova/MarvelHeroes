package com.gonza.MarvelHeroes.dataСlasses;

import com.gonza.MarvelHeroes.extraClasses.URLImage;

import java.util.LinkedList;
import java.util.Objects;

public class Hero {

    private int ID;
    private String name;
    private String description;
    private URLImage image;
    private LinkedList<Comics> ComicsList;

    public Hero(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URLImage getImage() {
        return image;
    }

    public void setImage(URLImage image) {
        this.image = image;
    }

    public LinkedList<Comics> getComicsList() {
        return ComicsList;
    }

    public void setComicsList(LinkedList<Comics> comicsList) {
        ComicsList = comicsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return ID == hero.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, description, image, ComicsList);
    }
}
