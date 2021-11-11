package com.gonza.MarvelHeroes.extra;

import lombok.Data;

import javax.persistence.*;
import  javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "url_image")
public class URLImage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="url_image_id", nullable = false)
    private Long ID;

    @Column(name = "path", nullable = false)
    @NotNull
    private String path;

    @Column(name = "extension", nullable = false)
    @NotNull
    private String extension;

    public URLImage(){

    }

    public URLImage(Long ID, String path, String extension){
        this.ID = ID;
        this.path = path;
        this.extension = extension;
    }
}
