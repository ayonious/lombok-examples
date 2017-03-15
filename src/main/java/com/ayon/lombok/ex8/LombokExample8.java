package com.ayon.lombok.ex8;

import com.ayon.lombok.ex6.LombokExample6;
import lombok.extern.slf4j.Slf4j;
import lombok.val;


/*
@Slf4j,
*/


@Slf4j
public class LombokExample8 {
    public void tryit () {
        log.info("info logs testing for lombok");
        log.warn("info logs testing for lombok");
        log.error("info logs testing for lombok");
    }
}

