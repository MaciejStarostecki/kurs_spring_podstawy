package com.strefakursow.kurs_spring_podstawy.config;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import com.strefakursow.kurs_spring_podstawy.domain.repository.DBKnightRepository;
import com.strefakursow.kurs_spring_podstawy.domain.repository.InMemoryKnightRepository;
import com.strefakursow.kurs_spring_podstawy.domain.repository.KnightRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

    @Bean
    @Profile("Dev")
    public KnightRepository createKnightInMemoRepo() {
        KnightRepository repository = new InMemoryKnightRepository();
        return repository;
    }

    @Bean
    @Profile("Prod")
    public KnightRepository createKnightInDBRepo() {
        KnightRepository repository = new DBKnightRepository();
        return repository;
    }

}
