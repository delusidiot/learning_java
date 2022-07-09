package com.delusidiot.spring.trace;

import java.util.UUID;

/**
 * author       : delusidiot
 * date         : 2022-07-08
 */

public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }
    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    /**
     *
     * @return 다음 depth 의 TraceId를 반환
     */
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
