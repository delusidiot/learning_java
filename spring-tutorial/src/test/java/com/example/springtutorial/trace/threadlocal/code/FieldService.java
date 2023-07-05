package com.example.springtutorial.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * author       : delusidiot
 * date         : 2022-07-11
 */

@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {
        log.info("store name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("search nameStore={}", nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
