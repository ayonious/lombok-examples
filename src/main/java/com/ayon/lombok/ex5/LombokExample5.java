package com.ayon.lombok.ex5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*

@RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
@NoArgsConstructor creates an empty constructor.
@AllArgsConstructor creates a constructor for all fields

*/


@Builder
@AllArgsConstructor
@Getter
@Setter
public class LombokExample5 {
    private String sentence;
    private boolean isValue;
    private String val;
}
