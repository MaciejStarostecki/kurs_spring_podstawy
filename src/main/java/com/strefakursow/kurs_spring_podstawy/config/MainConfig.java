package com.strefakursow.kurs_spring_podstawy.config;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import com.strefakursow.kurs_spring_podstawy.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MainConfig {

    @Bean
//    @Primary
    @Profile("Dev")
    public KnightRepository createKnightInMemoRepo() {
        KnightRepository repository = new InMemoryKnightRepository();
        return repository;
    }

    @Bean
    @Primary
    @Profile("Prod")
    public KnightRepository createKnightInDBRepo() {
        KnightRepository repository = new DBKnightRepository();
        return repository;
    }

    @Bean
//    @Primary
    @Profile("Dev")
    public QuestRepository createQuestInMemoRepo() {
        QuestRepository repository = new InMemoryQuestRepository();
        return repository;
    }

    @Bean
    @Primary
    @Profile("Prod")
    public QuestRepository createQuestInDBRepo() {
        QuestRepository repository = new DBQuestRepository();
        return repository;
    }
}
