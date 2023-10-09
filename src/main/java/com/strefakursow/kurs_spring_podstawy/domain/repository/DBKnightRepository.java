package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import jakarta.annotation.PostConstruct;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    public Knight getKnight(String name) {
        System.out.println("Używam bazy danych...");
        return null;
    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("Używam bazy danych...");
    }

    @Override
    @PostConstruct
    public void build() {

    }

//    public void setName(String name) {
//        this.name = name;
//    }

}
