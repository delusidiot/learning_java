package com.example.springtutorial.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * author       : delusidiot
 * date         : 2022-08-18
 */
@Slf4j
public class StrategyLogic2 implements Strategy{
    @Override
    public void call() {
        log.info("비즈니스 로직 2실행");
    }
}
