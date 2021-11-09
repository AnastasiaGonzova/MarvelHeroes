package com.gonza.MarvelHeroes.data;

import com.gonza.MarvelHeroes.extra.URLImage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;


@Entity
@Data
@Table(name = "Hero")
public class Hero {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="Hero_ID", nullable = false)
    private Long ID;

    @Column(name = "Hero_Name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "Hero_Description", nullable = false)
    @NotNull
    private String description;

    @OneToMany
    @JoinColumn(name="URLImage_ID")
    @NotNull
    private URLImage image;

    @ManyToMany
    @JoinTable(
            name = "HeroComics",
            joinColumns = { @JoinColumn(name = "Hero_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Comics_ID") }
    )
    private LinkedList<Comics> ComicsList;

    public Hero(){

    }
}
