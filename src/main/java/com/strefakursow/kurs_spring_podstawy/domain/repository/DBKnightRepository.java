package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import jakarta.annotation.PostConstruct;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class DBKnightRepository implements KnightRepository {


//    private String name;

    Map<String, Knight> knightMap = new HashMap<>();


    public DBKnightRepository() {

    }

//    InMemoryKnightRepository(String name) {
//        this.name = name;
//    }

    @Override
    public void createKnight(String name, int age) {
        System.out.println("Używam bazy danych...");
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("Używam bazy danych...");
        return null;
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        System.out.println("Używam bazy danych...");
        return null;
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println("Używam bazy danych...");
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("Używam bazy danych...");
    }

    @Override
    public Knight getKnightById(Integer id) {
        return null;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

}
