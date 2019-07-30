package com.ayon.service;

import com.ayon.lombok.ex1.LombokExample;
import com.ayon.lombok.ex2.LombokExample2;
import com.ayon.lombok.ex3.LombokExample3;
import com.ayon.lombok.ex4.LombokExample4;
import com.ayon.lombok.ex5.LombokExample5;
import com.ayon.lombok.ex6.LombokExample6;
import com.ayon.lombok.ex8.LombokExample8;

public class RunningLomboks {
    public void tryExample1 () {
        LombokExample ex1 = new LombokExample(10,"test",false);
        System.out.println(ex1.getSentence());
        System.out.println("Passed test example 1");
    }

    public void tryExample2 () {
        LombokExample2 ex2 = new LombokExample2(10,"test",false);
        ex2.setValue(true);
        System.out.println(ex2.getSentence());

        System.out.println("Passed test example 2");
    }

    public void tryExample3 () {

        //AllArgsConstructor
        LombokExample3 ex2 = new LombokExample3("sen",true,"as");

        //RequiredArgsConstructor
        LombokExample3 ex3 = new LombokExample3("sen");

        System.out.println("Passed test example 3");
    }

    public void tryExample4 () {
        //AllArgsConstructor
        LombokExample4 ex1 = new LombokExample4("sen",true,"as");
        System.out.println(ex1); //LombokExample4(sentence=sen, isValue=true)

        //AllArgsConstructor
        LombokExample4 ex2 = new LombokExample4("sen",true,"as");

        System.out.println(ex1.equals(ex2)); //true

        //NoArgsConstructor
        LombokExample4 ex3 = new LombokExample4();
        System.out.println(ex3);

        System.out.println("Passed test example 4");
    }

    public void tryExample5 () {
        //Builder
        LombokExample5 ex1 = LombokExample5.builder().isValue(true).sentence("asdf").val("asd").build();

        System.out.println("Passed test example 5");
    }

    //RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
    public void tryExample6 () {
        //Builder
        LombokExample6 ex1 = new LombokExample6("sentence");
        System.out.println("Passed test example 6");
    }

    //RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
    public void tryExample7 () {
        //Builder
        LombokExample6 ex1 = new LombokExample6("sentence",true, "val");
        System.out.println("Passed test example 7");
    }

    //NoArgsConstructor, generates a constructor without any fields
    public void tryExample8 () {
        //Builder
        LombokExample8 ex1 = new LombokExample8();
        System.out.println("Passed test example 8");
    }
}
