package com.than.repository;

import com.than.model.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMusicRepository {
    List<Music> findAll();
    void save(Music music);
    void delete(Long id);
    Music findById(Long id);
}
