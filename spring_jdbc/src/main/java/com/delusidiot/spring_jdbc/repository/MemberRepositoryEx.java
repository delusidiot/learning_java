package com.delusidiot.spring_jdbc.repository;

import com.delusidiot.spring_jdbc.domain.Member;

import java.sql.SQLException;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 *
 * SQLException 라는 Check Exception 때문에 종속적인 interface 가 된다.
 * 인터페이스가 특정 기술 구현에 오염이 되어 버렸다. -> 구현부에서 런타임 예외를 사용한다.
 */
public interface MemberRepositoryEx {
    Member save(Member member) throws SQLException;
    Member findById(String memberId) throws SQLException;
    void update(String memberId, int money) throws SQLException;
    void delete(String memberId) throws SQLException;
}
