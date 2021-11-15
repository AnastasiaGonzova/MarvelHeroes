package com.gonza.MarvelHeroes.data;

import com.gonza.MarvelHeroes.extra.URLImage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "comics")
public class Comics {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comics_id", nullable = false)
    private Long ID;

    @Column(name = "digital_id", nullable = false)
    @NotNull
    private Long digitalID;

    @Column(name = "comics_title", nullable = false)
    @NotNull
    private String title;

    @Column(name = "comics_description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "page_count", nullable = false)
    @NotNull
    private int pageCount;

    @ManyToOne
    @JoinColumn(name="url_image_id")
    private URLImage image;

    @ManyToMany(mappedBy = "comicsList")

    private List<Hero> heroList;

    public Comics(){

    }

    public Comics(Long digitalID, String title, String description, int pageCount, URLImage image, List<Hero> heroList) {
        this.digitalID = digitalID;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.image = image;
        this.heroList = heroList;
    }

    public Comics(Long digitalID, String title, String description, int pageCount, URLImage image) {
        this.ID = ID;
        this.digitalID = digitalID;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.image = image;
        this.heroList = null;
    }

    public Comics(Long digitalID, String title, String description, int pageCount) {
        this.ID = ID;
        this.digitalID = digitalID;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.image = null;
        this.heroList = null;
    }

    public Comics(Long ID, Long digitalID, String title, String description, int pageCount, URLImage image, List<Hero> heroList) {
        this.ID = ID;
        this.digitalID = digitalID;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.image = image;
        this.heroList = heroList;
    }
}
