package com.ayon.lombok.Example5_Builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*
@Builder annotation generates a builder pattern for the class
*/


@Builder
@AllArgsConstructor
@Getter
@Setter
public class Example5_Builder {
    private String sentence;
    private boolean isValue;
    private String val;
}
