package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import com.strefakursow.kurs_spring_podstawy.utils.Id;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryKnightRepository implements KnightRepository {

    Map<Integer, Knight> knightMap = new HashMap<>();


    public InMemoryKnightRepository() {
    }

    @Override
    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(Id.getNewId(knightMap.keySet()));
        knightMap.put(newKnight.getId(), newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knightMap.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Optional<Knight> knightByName = knightMap.values().stream().filter(knight -> knight.getName().equals(name)).findAny();
        return knightByName;
    }

    public Knight getKnight(Integer id) {
        return knightMap.get(id);
    }

    @Override
    public void deleteKnight(Integer id) {
        knightMap.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(Id.getNewId(knightMap.keySet()));
        knightMap.put(knight.getId(), knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knightMap.get(id);
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

    @Override
    public void updateKnight(int id, Knight knight) {
        knightMap.put(id, knight);
    }
}
