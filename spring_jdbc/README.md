# spring jdbc


## V0
순수한 JDBC 를 사용하여 CRUD 를 구현하였습니다.

## V1

JDBC 를 사용한 CRUD 에서 Transaction 을 사용하지 않아 발생하는 문제를 살펴보기 위한 코드입니다.

## V2

Transaction 을 적용하였습니다.

하지만 Service 에서 JDBC 에 의존적인 부분이 남아 있습니다.

Controller 와 Service 그리고 Repository 에 대한 분리가 명확하지 않습니다.

특히 Service 영역은 다른 기술에 의존적이지 않고 순수한 Java 로만 작성될 수 있도록 해야 합니다. 해당 버전에서는 Transaction 의 적용으로 JDBC 에 의존적인 형태입니다.

## V3