package com.delusidiot.spring_jdbc.repository.ex;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 */
public class MyDuplicateKeyException extends MyDBException{
    public MyDuplicateKeyException() {
    }

    public MyDuplicateKeyException(String message) {
        super(message);
    }

    public MyDuplicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDuplicateKeyException(Throwable cause) {
        super(cause);
    }
}
