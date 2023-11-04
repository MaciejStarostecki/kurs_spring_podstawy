package com.strefakursow.kurs_spring_podstawy.controllers;

import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import com.strefakursow.kurs_spring_podstawy.domain.PlayerInformation;
import com.strefakursow.kurs_spring_podstawy.services.KnightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = service.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("playerInformation", playerInformation);
        return "knight";

    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("playerInformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnights(@Valid Knight knight, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            System.out.println("Formularz został błędnie wypełniony :<");
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage());
            });
            return "knightform";
        }
        else {
            service.saveKnight(knight);
            return "redirect:/knights";
        }

    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnights(@PathVariable Integer id) {
        service.deleteKnight(id);
        return "redirect:/knights";
    }

}
