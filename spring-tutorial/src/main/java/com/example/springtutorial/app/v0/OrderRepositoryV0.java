package com.example.springtutorial.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * author       : delusidiot
 * date         : 2022-07-08
 */

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) {
        // save logic
        if (itemId.equals("ex")) {
            throw new IllegalStateException("Exception!!");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
