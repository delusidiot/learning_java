package com.delusidiot.spring_jdbc.exception.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 */
public class CheckedAppTest {

    @Test
    void checked() {
        Controller controller = new Controller();
        Assertions.assertThatThrownBy(() -> controller.request()).isInstanceOf(Exception.class);
    }

    /**
     * 복구 불가능한 예외 -> 대부분의 예외는 복구가 불가능하다.
     * 의존 관계에 대한 문제 -> 체크 예외이기 때문에 컨트롤러나 서비스 입장에서 본인이 처리할 수 없어도 어쩔수 없이 `throws`를 통해 던져야한다.
     * 처리하지도 못하는 Exception 때문에 Service 에서는 해당 Exception 에 의존하게 된다.
     * (Service 에서 SQLException 에서 JPAException 으로 변경)]
     * 깔끔하게 최상위 Exception 으로 변경하면 해결될 것 같아보이나 최상위 타입이므로 모든 체크 예외를 다 밖으로 던져버려
     * 의도적으로 CheckException 을 해야하는 경우에도 던져버린다. (ANTI Pattern) -> RuntimeException 으로 해결
     */
    static class Controller {
        Service service = new Service();

        public void request() throws SQLException, ConnectException {
            service.logic();
        }
    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        public void logic() throws SQLException, ConnectException {
            repository.call();
            networkClient.call();
        }
    }

    static class NetworkClient {
        public void call() throws ConnectException {
            throw new ConnectException("connect fail");
        }
    }

    static class Repository {
        public void call() throws SQLException {
            throw new SQLException("ex");
        }
    }
}
