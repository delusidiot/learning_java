package com.delusidiot.spring_jdbc.domain;

import lombok.Data;

/**
 * author : delusidiot
 * date : 2022-07-03
 */
@Data
public class Member {
    private String memberId;
    private int money;

    public Member() {

    }

    public Member(String memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }
}

