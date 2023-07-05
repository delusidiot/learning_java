package com.example.springtutorial.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * author       : delusidiot
 * date         : 2022-07-11
 */

@Slf4j
public class ThreadLocalService {

    private final ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("store name={} -> nameStore={}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("search nameStore={}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
