package com.gonza.MarvelHeroes.extra;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import  javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;

@Entity
@Data
@Table(name = "url_image")
public class URLImage {
    private final static String resourcePath = new URLImage().getClass().getResource("/").getPath();

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

    public URLImage(String path, String extension){
        this.path = path;
        this.extension = extension;
    }

    public URLImage(Long ID, String path, String extension){
        this.ID = ID;
        this.path = path;
        this.extension = extension;
    }

    public static URLImage ImageProcessing(MultipartFile file) throws IOException {
        String pathDir = new StringBuilder(resourcePath).append("static/images/").toString();
        if(file!= null){
            File dir = new File(pathDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            String pathFile = new StringBuilder(pathDir).append(file.getOriginalFilename()).toString();
            File copy = new File(pathFile);
            file.transferTo(copy);
            return new URLImage("/images/"+file.getOriginalFilename(), "jpg");
        }
        return null;
    }
}
