package com.ayon.lombok.Example7_NoArgsConstructor;

import lombok.*;

/*

@RequiredArgsConstructor, generates a constructor for all final fields, with parameter order same as field order
@NoArgsConstructor creates an empty constructor.
@AllArgsConstructor creates a constructor for all fields

*/

@NoArgsConstructor
@Getter
@Setter
public class Example7_NoArgsConstructor {
    private boolean isValue;
    private String val;
}
