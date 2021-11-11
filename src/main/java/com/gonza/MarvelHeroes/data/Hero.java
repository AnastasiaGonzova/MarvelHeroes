package com.gonza.MarvelHeroes.data;

import com.gonza.MarvelHeroes.extra.URLImage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Table(name = "hero")
public class Hero {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="hero_id", nullable = false)
    private Long ID;

    @Column(name = "hero_name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "hero_description", nullable = false)
    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name="url_image_id")
    private URLImage image;

    @ManyToMany
    @JoinTable(
            name = "hero_comics",
            joinColumns = { @JoinColumn(name = "hero_id") },
            inverseJoinColumns = { @JoinColumn(name = "comics_id") }
    )
    private List<Comics> comicsList;

    public Hero(){

    }

    public Hero(Long ID, String name, String description, URLImage image, List<Comics> comicsList) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.image = image;
        this.comicsList = comicsList;
    }
}
