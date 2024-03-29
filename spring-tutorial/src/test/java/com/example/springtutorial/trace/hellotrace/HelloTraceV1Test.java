package com.example.springtutorial.trace.hellotrace;

import com.example.springtutorial.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * author       : delusidiot
 * date         : 2022-07-08
 */
class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }

}