package com.than.service;

import com.than.model.Music;
import com.than.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(Long id) {
        musicRepository.delete(id);
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id);
    }




}
