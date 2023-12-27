package com.hospital.business.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum StatusCodeLevel {
    SUCCESS('S'), INFO('I'), WARNING('W'), ERROR('E'), FATAL('F');

    private Character code;

    private static final Map<Character,StatusCodeLevel> lookup=new HashMap<>();

    static{
        for(StatusCodeLevel s: EnumSet.allOf(StatusCodeLevel.class)){
            lookup.put(s.getCode(),s);
            lookup.put(Character.toUpperCase(s.getCode()),s);
        }

    }

    StatusCodeLevel(Character code) {
        this.code = code;
    }

    public static StatusCodeLevel fromCode(Character value){
        return lookup.get(value);
    }

    public static StatusCodeLevel fromString(Character value){
        return lookup.get(value);
    }

    public Character getCode() {
        return code;
    }
}
