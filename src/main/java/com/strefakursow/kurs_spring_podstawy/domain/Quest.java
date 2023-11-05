package com.strefakursow.kurs_spring_podstawy.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;

    private int reward = 100;

    protected int lengthInSeconds = 10;

    private boolean started = false;

    private boolean finnished = false;

    protected LocalDateTime startDate;


    public Quest() {}

    public Quest(String description) {
        this.description = description;
    }

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getInSeconds() {
        return lengthInSeconds;
    }

    public void setInSeconds(int length) {
        this.lengthInSeconds = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if(started) {
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isFinnished() {

        if(this.finnished) {
            return this.finnished;
        }
        else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lengthInSeconds);

            boolean isAfter = now.isAfter(questEndDate);

            if(isAfter) {
                this.finnished = true;
            }

            return isAfter;
        }
    }


}
