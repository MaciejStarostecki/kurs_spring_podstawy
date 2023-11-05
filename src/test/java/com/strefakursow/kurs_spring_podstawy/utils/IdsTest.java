package com.strefakursow.kurs_spring_podstawy.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class IdsTest {

    @Test
    public void testEmptySet() {
        int result = Id.getNewId(Collections.emptySet());
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testGenerateNewId() {
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        sample.add(5);
        sample.add(6);
        int result = Id.getNewId(sample);
        Assertions.assertEquals(7, result);
    }

}
