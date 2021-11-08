package com.gonza.MarvelHeroes.extra;

import lombok.Data;

import javax.persistence.*;
import  javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "URLImage")
public class URLImage {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="URLImage_ID", nullable = false)
    private int ID;

    @Column(name = "Path", nullable = false)
    @NotNull
    private String path;

    @Column(name = "Extension", nullable = false)
    @NotNull
    private String extension;

    public URLImage(){

    }
}
