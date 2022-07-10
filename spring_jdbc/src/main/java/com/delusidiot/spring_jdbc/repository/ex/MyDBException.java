package com.delusidiot.spring_jdbc.repository.ex;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 */
public class MyDBException extends RuntimeException{

    public MyDBException() {
    }

    public MyDBException(String message) {
        super(message);
    }

    public MyDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDBException(Throwable cause) {
        super(cause);
    }
}
