package com.example.springtutorial.trace.hellotrace;

import com.example.springtutorial.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * author       : delusidiot
 * date         : 2022-07-08
 */
class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        Exception exception = new IllegalStateException();
        trace.exception(status2, exception);
        trace.exception(status1, exception);
    }

}