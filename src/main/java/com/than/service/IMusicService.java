package com.than.service;

import com.than.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
}
