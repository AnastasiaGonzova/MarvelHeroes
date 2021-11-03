package com.gonza.MarvelHeroes.dataСlasses;

import com.gonza.MarvelHeroes.extraClasses.URLImage;

import java.util.LinkedList;
import java.util.Objects;

public class Comics {

    private int ID;
    private int digitalID;
    private String title;
    private String description;
    private int pageCount;
    private URLImage Image;
    private LinkedList<Hero> HeroList;

    public Comics(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDigitalID() {
        return digitalID;
    }

    public void setDigitalID(int digitalID) {
        this.digitalID = digitalID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public URLImage getImage() {
        return Image;
    }

    public void setImage(URLImage image) {
        Image = image;
    }

    public LinkedList<Hero> getHeroList() {
        return HeroList;
    }

    public void setHeroList(LinkedList<Hero> heroList) {
        HeroList = heroList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comics comics = (Comics) o;
        return ID == comics.ID &&
                digitalID == comics.digitalID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, digitalID, title, description, pageCount, Image, HeroList);
    }
}
