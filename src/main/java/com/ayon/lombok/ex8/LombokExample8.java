package com.ayon.lombok.ex8;

import lombok.*;

/*

@RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
@NoArgsConstructor creates an empty constructor.
@AllArgsConstructor creates a constructor for all fields

*/

@NoArgsConstructor
@Getter
@Setter
public class LombokExample8 {
    private boolean isValue;
    private String val;
}
