package com.strefakursow.kurs_spring_podstawy.services;

import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import com.strefakursow.kurs_spring_podstawy.domain.repository.KnightRepository;
import com.strefakursow.kurs_spring_podstawy.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {


    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random random = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = questRepository.getAll().get(random.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));

    }

    public List<Quest> getAllNotStartedQuests() {
        return questRepository.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    public void update(Quest quest) {
        questRepository.update(quest);
    }

    public boolean isQuestFinnished(Quest quest) {
        return quest.isFinnished();
    }
}
