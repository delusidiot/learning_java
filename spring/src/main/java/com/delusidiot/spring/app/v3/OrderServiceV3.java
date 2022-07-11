package com.delusidiot.spring.app.v3;

import com.delusidiot.spring.trace.TraceId;
import com.delusidiot.spring.trace.TraceStatus;
import com.delusidiot.spring.trace.hellotrace.HelloTraceV2;
import com.delusidiot.spring.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * author       : delusidiot
 * date         : 2022-07-08
 */

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
