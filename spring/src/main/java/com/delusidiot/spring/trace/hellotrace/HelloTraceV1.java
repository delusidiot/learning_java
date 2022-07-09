package com.delusidiot.spring.trace.hellotrace;

import com.delusidiot.spring.trace.TraceId;
import com.delusidiot.spring.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * author       : delusidiot
 * date         : 2022-07-08
 */

@Slf4j
@Component
public class HelloTraceV1 {
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    /**
     * Log 시작
     * @param message Log 에 들어갈 message
     * @return 현재 Log 상태
     */
    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    /**
     * 정상 종료시 종료Log 출력
     * @param status Log 에 들어갈 정보 (실행시간, 시작과 같은 로그 메세지)
     */
    public void end(TraceStatus status) {
        complete(status, null);
    }

    /**
     * 예외상황의 종료Log 를 출력
     * @param status Log 에 들어갈 정보 (실행시간, 시작과 같은 로그 메세지)
     * @param e 예외정보
     */
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    /**
     * end(), exception()의 요청 흐름을 한곳에서 처리
     * @param status Log 에 들어갈 정보 (실행시간, 시작과 같은 로그 메세지)
     * @param e 예외정보
     */
    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, e.toString());
        }
    }

    /**
     * @param prefix 화살표
     * @param level depth
     * @return  level == 0
     *          level == 1      |-->
     *          level == 2      |   |-->
     *          level == 2 ex   |   |<X-
     *          level == 1 ex   | <X-
     */
    private static String addSpace(String prefix, int level) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }
}
