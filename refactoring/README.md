# Refactoring

- 처음부터 완벽하게 시스템을 설계하는 것은 매우 어려운 일이다.
- 이미 코드를 작성한 이후에 구조를 변경하는 일이 발생한다.
- 리팩토링으로 애플리케이션 구조를 꾸준이 개선해 나가야 한다.
- 구조 변경으로 인한 버그를 줄이면서 코드를 깔끔하게 유지할 수 있는 방법이다.

## [Mysterious name](src/main/java/com/delusidiot/refactoring/smell01_mysterious_name)

- 깔끔한 코드에서 가장 중요한 것 중 하나가 바로 "좋은 이름"이다.
- 함수, 변수, 클래스, 모듈의 이름 등 모두 어떤 역할을 하는지 어떻게 쓰이는지 직관적이어야 한다.
- 사용할 수 있는 리팩토링 기술
  - 함수 선언 변경하기 ([Change Function Declaration](src/main/java/com/delusidiot/refactoring/smell01_mysterious_name/_01_change_function_declaration))
  - 변수 이름 바꾸기 ([Rename Variable](src/main/java/com/delusidiot/refactoring/smell01_mysterious_name/_02_rename_variable))
  - 필드 이름 바꾸기 ([Rename Field](src/main/java/com/delusidiot/refactoring/smell01_mysterious_name/_03_rename_field))

## [Duplicated Code](src/main/java/com/delusidiot/refactoring/smell02_duplicated_code)

복사 붙여넣기로 동일한 코드가 생길수도 있으며 정말 비슷한 코드인데 조금만 변경하면 동일한 코드가 될수도 있다.
또는 코드의 절차가 비슷한 경우가 있다. 가령 JDBC의 경우 각 메소드 마다 읽고 쓰는 여러 작업을 각기 다른 메소드에 구현할 수 있는데
이중 Connection을 받아 온다던지 ResultSet을 닫는다 던지 하는 동작은 모두 같은 작업이 이루어지는 것을 볼 수 있다.
이러한 코드들을 어떻게 리팩토링 해야할지 생각해 보자.

#### 중복 코드의 단점

- 중복된 코드는 중복된 코드끼리 비슷한지, 완전히 동일한 작업을 하는지 차이점을 알아내기 위해 주의깊게 살펴봐야하고 이러한 작업은 에너지 소모가 크다.
- 중복된 코드들은 하나를 변경하기 위해서는 다른 모든 중복된 코드들도 변경해야한다. 이때 변경을 누락해 버그가 발생할 위험이 있다.

#### 사용할 수 있는 리팩토링 기술

- 동일한 코드를 여러 메소드에서 사용하는 경우, 함수 추출하기 (Extract Function)
  - 함수 추출하기는 중복된 코드 뿐만 아니라 다른 냄새들을 제거하는데도 유용하게 사용된다.
- 코드가 비슷하게 생겼지만 완전히 같지는 않은 경우, 코드 분리하기 (Slide Statements)
  - 완전히 같지 않은 코드에서 코드를 어느정도 움직이다 보면 같은 코드들이 만들어 질 수 있다.
- 여러 하위 클래스에 동일한 코드가 있다면, 메소드 올리기 (Pull Up Method)

## 참조
- [코딩으로 학습하는 리팩토링](https://www.inflearn.com/course/%EB%A6%AC%ED%8C%A9%ED%86%A0%EB%A7%81/dashboard)
- 한빛미디어 REFACTORING 2판 (책)