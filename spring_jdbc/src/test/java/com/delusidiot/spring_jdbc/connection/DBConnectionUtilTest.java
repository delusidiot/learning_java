package com.delusidiot.spring_jdbc.connection;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * author : delusidiot
 * date : 2022-07-03
 */

@Slf4j
class DBConnectionUtilTest {

    @Test
    @DisplayName("Connection Test")
    void connection() {
        Connection connection = DBConnectionUtil.getConnection();
        Assertions.assertThat(connection).isNotNull();
    }
}
