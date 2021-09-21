package com.than.repository;

import com.than.model.Music;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MusicRepository implements IMusicRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Music> findAll() {
        String queryStr = "select  m from Music as m";
        List<Music> musicList = entityManager.createQuery(queryStr, Music.class ).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        if(music.getId()!=null){
            entityManager.merge(music);
        } else {
            entityManager.persist(music);
        }
    }

    @Override
    public void delete(Long id) {
        Music music = findById(id);
        if(music!=null){
            entityManager.remove(music);
        }
    }

    @Override
    public Music findById(Long id) {
        String queryStr = "select m from Music as m where m.id =:id";
        Music music = entityManager.createQuery(queryStr,Music.class).setParameter("id",id).getSingleResult();
        return music;
    }

}
