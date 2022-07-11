package com.delusidiot.spring.trace.threadlocal;

import com.delusidiot.spring.trace.threadlocal.code.FieldService;
import com.delusidiot.spring.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * author       : delusidiot
 * date         : 2022-07-12
 */

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void thread_local() {
        log.info("main start");
        Runnable userA = () -> {
            service.logic("userA");
        };
        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);
        threadB.start();

        sleep(3000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
