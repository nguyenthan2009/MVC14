package com.than.service;

import com.than.model.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MusicService implements IMusicService{
    private static ArrayList<Music> musics = new ArrayList<>();
    static {
        musics.add(new Music(1, "Co don danh cho ai","tuanphong" ,"nhac tre"));
        musics.add(new Music(1, "Ha con vuong nang","nguyen than" ,"nhac vang"));
        musics.add(new Music(1, "Khi nguoi minh yeu khoc","phuong phuong" ,"nhac remix"));
    }
    @Override
    public List<Music> findAll() {
        return musics;
    }

    @Override
    public void save(Music music) {
        musics.add(music);

    }
}
