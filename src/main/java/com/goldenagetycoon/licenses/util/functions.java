package com.goldenagetycoon.licenses.util;


import java.util.Collection;
import java.util.Objects;

public class functions {

    public static boolean listCheck(Collection<String> allElements, Collection<String> randomElements){
        int count = 0;
        for(Object a: allElements){
            for(Object b : randomElements){
                if(Objects.equals(a.toString(), b.toString())){
                    count++;
                }
            }
        }
        return count >= 2;
    }
}
