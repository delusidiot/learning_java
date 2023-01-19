package com.delusidiot.spring.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * author       : delusidiot
 * date         : 2022-08-16
 */
@Slf4j
public class SubClassLogic1 extends AbstractTemplate {

    @Override
    protected void call() {
      log.info("비즈니스 로직 1");
    }
}
