package com.ayon.lombok.ex1;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


/*
Generate getters and setters for whole class
*/

@Getter
@Setter
public class LombokExample {
    private final String sentence;
    private boolean isValue;
    private List<String> strList;
    private Map<String,String> mapString;
    private final int someVal;

    public LombokExample(int someVal, String sentence, boolean isValue) {
        this.someVal = someVal;
        this.sentence = sentence;
        this.isValue = isValue;
    }
}