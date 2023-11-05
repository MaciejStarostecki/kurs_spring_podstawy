package com.strefakursow.kurs_spring_podstawy.controllers;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import com.strefakursow.kurs_spring_podstawy.domain.PlayerInformation;
import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import com.strefakursow.kurs_spring_podstawy.services.KnightService;
import com.strefakursow.kurs_spring_podstawy.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuest = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuest", notStartedQuest);
        return "assignQuest";
    }

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String assignQuest(Knight knight) {
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.update(quest);

        return "redirect:/knights";
    }

    @RequestMapping(value = "/checkQuest")
    public String checkQuest(Knight knight) {
        knightService.getMyGold();

        return "redirect:/knights";
    }

}
