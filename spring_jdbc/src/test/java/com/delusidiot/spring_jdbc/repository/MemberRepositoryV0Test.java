package com.delusidiot.spring_jdbc.repository;

import com.delusidiot.spring_jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

/**
 * author : delusidiot
 * date : 2022-07-03
 */
@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("v100", 10000);
        Member save = repositoryV0.save(member);

        //findById
        Member findMember = repositoryV0.findById(member.getMemberId());
        Assertions.assertThat(findMember).isEqualTo(member);

        //update
        member.setMoney(20000);
        repositoryV0.update(member.getMemberId(), member.getMoney());
        Member updateMember = repositoryV0.findById(member.getMemberId());
        Assertions.assertThat(updateMember).isEqualTo(member);

        //delete
        repositoryV0.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> repositoryV0.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
        /*
        테스트 중간에 오류가 발생하면 DB에 데이터가 남아 다른 테스트에 영향을 줄 수 있어 해당 방법은 좋지 못한 테스트 방법이다.
         */
    }
}