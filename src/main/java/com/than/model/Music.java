package com.than.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    private Long id;
    private String nameMusic;
    private String author;
    private String category;
    private String music;

    public Music() {
    }
    public Music(Long id, String nameMusic,String author,String category){
        this.id = id;
        this.nameMusic = nameMusic;
        this.author = author;
        this.category = category;
    }

    public Music( Long id,String nameMusic, String author, String category, String music) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.author = author;
        this.category = category;
        this.music = music;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
