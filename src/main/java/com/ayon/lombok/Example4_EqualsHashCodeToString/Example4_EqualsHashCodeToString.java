package com.ayon.lombok.Example4_EqualsHashCodeToString;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
Just read the class, added a nice to string method and a Equals and Hashcode method
*/


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"sentence", "val"})
@ToString(exclude = "val")
public class Example4_EqualsHashCodeToString {
    private String sentence;
    private boolean isValue;
    private String val;
}
