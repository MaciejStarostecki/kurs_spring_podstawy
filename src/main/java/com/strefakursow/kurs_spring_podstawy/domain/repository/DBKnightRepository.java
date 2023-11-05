package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class DBKnightRepository implements KnightRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public DBKnightRepository() {}


    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);

        entityManager.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return entityManager.createQuery("from Knight", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = entityManager.createQuery("from Knight k where k.name=:name", Knight.class).setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        entityManager.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    public void createKnight(Knight knight) {
        entityManager.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return entityManager.find(Knight.class, id);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {
        entityManager.merge(knight);
    }

}
