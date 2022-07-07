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

DataSourceUtils.getConnection() 을 통해 connection 을 가지고 와서 사용한다.

V2에서 처럼 Connection 을 받는 함수를 따로 생성할 필요 없어진다.

트랜잭션은 DataSourceUtils.releaseConnection()를 통해 잠시 반환할 뿐 트랜잭션은 비즈니스 로직이 끝나고나면 종료된다.
비즈니스 로직에서 commit 또는 rollback 에 의해서만 트랜잭션이 종료된다.

JDBC 에서 JPA 로 변경한다해도 의존관계 주입만 DataSourceTransactionManager 에서 JpaTransactionManager 로 변경해 주면 된다.

### 참조

- [스프링 DB 1편 데이터 접근 핵심 원리](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-db-1/dashboard)
- [자바 ORM 표준 JPA프로그래밍](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788960777330&orderClick=LAG&Kc=)