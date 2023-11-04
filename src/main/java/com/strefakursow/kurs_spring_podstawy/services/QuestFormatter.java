package com.strefakursow.kurs_spring_podstawy.services;

import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import com.strefakursow.kurs_spring_podstawy.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class QuestFormatter implements Formatter<Quest> {

    @Autowired
    QuestRepository questRepository;

    @Override
    public Quest parse(String idAsStr, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idAsStr);
        return questRepository.getQuest(id);
    }

    @Override
    public String print(Quest object, Locale locale) {
        return object.toString();
    }
}
