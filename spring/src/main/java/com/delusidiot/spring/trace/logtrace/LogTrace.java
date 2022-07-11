package com.delusidiot.spring.trace.logtrace;

import com.delusidiot.spring.trace.TraceStatus;

/**
 * author       : delusidiot
 * date         : 2022-07-11
 */
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
