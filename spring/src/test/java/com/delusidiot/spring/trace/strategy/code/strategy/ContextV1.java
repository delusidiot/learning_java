package com.delusidiot.spring.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * author       : delusidiot
 * date         : 2022-08-18
 * 필드에 전략을 보관
 */

@Slf4j
public class ContextV1 {
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        strategy.call(); //위임

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
