package com.strefakursow.kurs_spring_podstawy;


import com.strefakursow.kurs_spring_podstawy.domain.PlayerInformation;
import com.strefakursow.kurs_spring_podstawy.domain.repository.KnightRepository;
import com.strefakursow.kurs_spring_podstawy.domain.repository.QuestRepository;
import com.strefakursow.kurs_spring_podstawy.services.QuestService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Starter implements CommandLineRunner {


    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Lancelot", 29);
        knightRepository.createKnight("Percival", 25);


        questService.assignRandomQuest("Percival");

    }
}
