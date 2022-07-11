package com.delusidiot.spring_jdbc.repository;

import com.delusidiot.spring_jdbc.domain.Member;

import java.sql.SQLException;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 */
public interface MemberRepository {
    Member save(Member member);
    Member findById(String memberId);
    void update(String memberId, int money);
    void delete(String memberId);
}
