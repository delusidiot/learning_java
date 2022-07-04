package com.delusidiot.spring_jdbc.repository;

import com.delusidiot.spring_jdbc.connection.ConnectionConst;
import com.delusidiot.spring_jdbc.domain.Member;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static com.delusidiot.spring_jdbc.connection.ConnectionConst.*;

/**
 * author : delusidiot
 * date : 2022-07-03
 */
@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach() {
/*        기본 DriverManager - 항상 새로운 커넥션 획득
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        DataSource 라는 추상화된 인터베이스를 사용했기 때문에 Repository 에서 DataSource 를 구현한 것을 주입 받을 수 있다. (DI)
 */
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        repository = new MemberRepositoryV1(dataSource);
        /*
        HikariProxyConnection 를 생성해서 Connection 을 담아 준뒤 사용후 ConnectionPool 에 반환한다 그리고 HikariProxyConnection 은 삭제.
        Connection 은 지정된 기본 10가지 중에서 사용하지만 HikariProxyConnection 의 객체가 다른 이유가 이때문이다.
         */
    }

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("v100", 10000);
        Member save = repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        Assertions.assertThat(findMember).isEqualTo(member);

        //update
        member.setMoney(20000);
        repository.update(member.getMemberId(), member.getMoney());
        Member updateMember = repository.findById(member.getMemberId());
        Assertions.assertThat(updateMember).isEqualTo(member);

        //delete
        repository.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}