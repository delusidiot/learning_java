package com.delusidiot.spring.trace.templage;

import com.delusidiot.spring.trace.TraceStatus;
import com.delusidiot.spring.trace.logtrace.LogTrace;

/**
 * author       : delusidiot
 * date         : 2022-08-17
 */
public abstract class AbstractTemplate<T> {
    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);
            T result = call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
