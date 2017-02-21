package com.ayon.lombok.ex3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*

@RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
@NoArgsConstructor creates an empty constructor.
@AllArgsConstructor creates a constructor for all fields

*/


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LombokExample3 {
    private final String sentence;
    private boolean isValue;
    private String val;
}
