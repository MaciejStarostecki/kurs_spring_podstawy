package com.strefakursow.kurs_spring_podstawy.services;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import com.strefakursow.kurs_spring_podstawy.domain.PlayerInformation;
import com.strefakursow.kurs_spring_podstawy.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    PlayerInformation playerInformation;


    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null)
                return knight.getQuest().isFinnished();
            else
                return false;
        };

        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate)
                .forEach(knight -> knight.setQuest(null));

        return sum;
    }

    public void getMyGold() {

        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight1 -> {
            if (knight1.getQuest() != null) {
                knight1.getQuest().isFinnished();
            }

        });

        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + collectRewards());

    }

}
