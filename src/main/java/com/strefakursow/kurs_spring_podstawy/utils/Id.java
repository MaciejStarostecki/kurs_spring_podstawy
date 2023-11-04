package com.strefakursow.kurs_spring_podstawy.utils;

import java.util.Set;

public class Id {

    static public int getNewId(Set<Integer> keysSoFar) {
        if(keysSoFar.isEmpty()) {
            return 0;
        }
        else {
            Integer integer = keysSoFar.stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return integer+1;
        }
    }
}
