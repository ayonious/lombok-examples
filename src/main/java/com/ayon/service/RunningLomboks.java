package com.ayon.service;

import com.ayon.lombok.Example1_GettersSetters.Example1_GettersSetters;
import com.ayon.lombok.Example2_AccessControl.Example2_AccessControl;
import com.ayon.lombok.Example3_Constructors.Example3_Constructors;
import com.ayon.lombok.Example4_EqualsHashCodeToString.Example4_EqualsHashCodeToString;
import com.ayon.lombok.Example5_Builder.Example5_Builder;
import com.ayon.lombok.Example6_ConstructorVariations.Example6_ConstructorVariations;
import com.ayon.lombok.Example7_NoArgsConstructor.Example7_NoArgsConstructor;

public class RunningLomboks {
    public void tryExample1 () {
        Example1_GettersSetters ex1 = new Example1_GettersSetters(10,"test",false);
        System.out.println(ex1.getSentence());
        System.out.println("Passed test example 1");
    }

    public void tryExample2 () {
        Example2_AccessControl ex2 = new Example2_AccessControl(10,"test",false);
        ex2.setValue(true);
        System.out.println(ex2.getSentence());

        System.out.println("Passed test example 2");
    }

    public void tryExample3 () {

        //AllArgsConstructor
        Example3_Constructors ex2 = new Example3_Constructors("sen",true,"as");

        //RequiredArgsConstructor
        Example3_Constructors ex3 = new Example3_Constructors("sen");

        System.out.println("Passed test example 3");
    }

    public void tryExample4 () {
        //AllArgsConstructor
        Example4_EqualsHashCodeToString ex1 = new Example4_EqualsHashCodeToString("sen",true,"as");
        System.out.println(ex1); //Example4_EqualsHashCodeToString(sentence=sen, isValue=true)

        //AllArgsConstructor
        Example4_EqualsHashCodeToString ex2 = new Example4_EqualsHashCodeToString("sen",true,"as");

        System.out.println(ex1.equals(ex2)); //true

        //NoArgsConstructor
        Example4_EqualsHashCodeToString ex3 = new Example4_EqualsHashCodeToString();
        System.out.println(ex3);

        System.out.println("Passed test example 4");
    }

    public void tryExample5 () {
        //Builder
        Example5_Builder ex1 = Example5_Builder.builder().isValue(true).sentence("asdf").val("asd").build();

        System.out.println("Passed test example 5");
    }

    //RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
    public void tryExample6 () {
        //Constructor with required fields
        Example6_ConstructorVariations ex1 = new Example6_ConstructorVariations("sentence");
        System.out.println("Passed test example 6");
    }

    //RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
    public void tryExample7 () {
        //AllArgsConstructor
        Example6_ConstructorVariations ex1 = new Example6_ConstructorVariations("sentence",true, "val");
        System.out.println("Passed test example 7");
    }

    //NoArgsConstructor, generates a constructor without any fields
    public void tryExample8 () {
        //NoArgsConstructor
        Example7_NoArgsConstructor ex1 = new Example7_NoArgsConstructor();
        System.out.println("Passed test example 8");
    }
}
