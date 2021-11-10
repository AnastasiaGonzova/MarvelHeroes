package com.gonza.MarvelHeroes.data;

import com.gonza.MarvelHeroes.extra.URLImage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "Comics")
public class Comics {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="Comics_ID", nullable = false)
    private Long ID;

    @Column(name = "digitalID", nullable = false)
    @NotNull
    private Long digitalID;

    @Column(name = "Comics_Title", nullable = false)
    @NotNull
    private String title;

    @Column(name = "Comics_Description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "pageCount", nullable = false)
    @NotNull
    private int pageCount;

    @OneToMany
    @JoinColumn(name="URLImage_ID")
    @NotNull
    private URLImage image;

    @ManyToMany(mappedBy = "Comics")
    private List<Hero> heroList;

    public Comics(){

    }

    public Comics(Long ID, Long digitalID, String title, String description, int pageCount, URLImage image) {
        this.ID = ID;
        this.digitalID = digitalID;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.image = image;
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
