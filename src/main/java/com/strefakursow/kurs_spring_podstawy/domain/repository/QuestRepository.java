package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import com.strefakursow.kurs_spring_podstawy.utils.Id;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface QuestRepository {
    public void createQuest(String description);

    public void deleteQuest(Quest quest);
    public List<Quest> getAll();

    public void createRandomQuest();

    public void update(Quest quest);

    public Quest getQuest(Integer id);
}
