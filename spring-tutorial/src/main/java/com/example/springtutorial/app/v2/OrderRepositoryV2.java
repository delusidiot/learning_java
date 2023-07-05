package com.example.springtutorial.app.v2;

import com.example.springtutorial.trace.TraceId;
import com.example.springtutorial.trace.TraceStatus;
import com.example.springtutorial.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * author       : delusidiot
 * date         : 2022-07-08
 */

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) {
        // save logic
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception!!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
