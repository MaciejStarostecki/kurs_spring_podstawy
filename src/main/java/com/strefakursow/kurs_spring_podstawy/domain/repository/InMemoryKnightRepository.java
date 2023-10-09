package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryKnightRepository implements KnightRepository {


//    private String name;

    Map<String, Knight> knightMap = new HashMap<>();


    public InMemoryKnightRepository() {
    }

//    InMemoryKnightRepository(String name) {
//        this.name = name;
//    }

    @Override
    public void createKnight(String name, int age) {
        knightMap.put(name, new Knight(name, age));
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knightMap.values();
    }

    @Override
    public Knight getKnight(String name) {
        return knightMap.get(name);
    }

    @Override
    public void deleteKnight(String name) {
        knightMap.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "InMemoryKnightRepository{" +
                "knightMap=" + knightMap +
                '}';
    }
}
