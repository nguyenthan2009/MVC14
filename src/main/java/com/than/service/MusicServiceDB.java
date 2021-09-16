package com.than.service;

import com.than.model.Music;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MusicServiceDB implements IMusicService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Music> findAll() {
        //typedQuery
        String qr = "SELECT c FROM Music AS c";
        TypedQuery<Music> query = entityManager.createQuery(qr, Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {
        Session session = null;
        Transaction transaction = null;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(music);
        transaction.commit();
    }


}
