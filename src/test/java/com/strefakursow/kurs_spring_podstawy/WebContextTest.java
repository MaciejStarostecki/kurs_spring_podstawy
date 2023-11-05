package com.strefakursow.kurs_spring_podstawy;

import com.strefakursow.kurs_spring_podstawy.controllers.QuestController;
import com.strefakursow.kurs_spring_podstawy.domain.Knight;
import com.strefakursow.kurs_spring_podstawy.domain.PlayerInformation;
import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import com.strefakursow.kurs_spring_podstawy.services.KnightService;
import com.strefakursow.kurs_spring_podstawy.services.QuestService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringRunner.class})
@WebAppConfiguration
public class WebContextTest {


    @Mock
    KnightService knightService;

    @Mock
    QuestService questService;

    @Mock
    PlayerInformation playerInformation;

    @InjectMocks
    QuestController questController;


    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(questController).build();
    }

    @Test
    public void testCheckQuest() throws Exception {

        Quest quest = new Quest(0, "Zadanie testowe");
        Knight knight1 = new Knight("Lancelot", 30);
        Knight knight2 = new Knight("Percival", 23);

        knight1.setQuest(quest);

        List<Knight> knights = new ArrayList<>(2);

        knights.add(knight2);
        knights.add(knight1);

        when(knightService.getAllKnights()).thenReturn(knights);

        mockMvc.perform(get("/checkQuest"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/knights"));

    }

    @Test
    public void contextLoad() {

    }

}
