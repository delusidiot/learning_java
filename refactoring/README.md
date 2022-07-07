# Refactoring

- 처음부터 완벽하게 시스템을 설계하는 것은 매우 어려운 일이다.
- 이미 코드를 작성한 이후에 구조를 변경하는 일이 발생한다.
- 리팩토링으로 애플리케이션 구조를 꾸준이 개선해 나가야 한다.
- 구조 변경으로 인한 버그를 줄이면서 코드를 깔끔하게 유지할 수 있는 방법이다.

## [Mysterious name](src/main/java/com/delusidiot/refactoring/smell01_mysterious_name)

- 깔끔한 코드에서 가장 중요한 것 중 하나가 바로 "좋은 이름"이다.
- 함수, 변수, 클래스, 모듈의 이름 등 모두 어떤 역할을 하는지 어떻게 쓰이는지 직관적이어야 한다.
- 사용할 수 있는 리팩토링 기술
  - 함수 선언 변경하기 (Change Function Declaration)
  - 변수 이름 바꾸기 (Rename Variable)
  - 필드 이름 바꾸기 (Rename Field)

## 참조
- [코딩으로 학습하는 리팩토링](https://www.inflearn.com/course/%EB%A6%AC%ED%8C%A9%ED%86%A0%EB%A7%81/dashboard)
- 한빛미디어 REFACTORING 2판 (책)