package com.gonza.MarvelHeroes.data;

import com.gonza.MarvelHeroes.extra.URLImage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;

@Entity
@Data
@Table(name = "Comics")
public class Comics {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="Comics_ID", nullable = false)
    private int ID;

    @Column(name = "digitalID", nullable = false)
    @NotNull
    private int digitalID;

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
    private URLImage Image;

    @ManyToMany(mappedBy = "Comics")
    private LinkedList<Hero> HeroList;

    public Comics(){

    }
}
