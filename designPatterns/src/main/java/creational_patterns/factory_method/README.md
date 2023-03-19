# Factory method Pattern

구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다.
다양한 구현체 (Product)가 있고, 그중에서 특정한 구현체를 만들 수 있는 다양한 팩토리(Creator)를 제공할 수 있다.

![FactoryMethod](https://user-images.githubusercontent.com/65374355/178108301-a7802e4c-aa10-4f9d-94e6-baa2d498e8f7.png)

## 장점

- OCP원칙을 지킬 수 있다.
- 기존 코드를 건드리지 않고 새로운 인스턴스를 다른 방법으로 확장이 가능하다.
- Product와 Create간의 관계를 loosely coupled하게 되어 가능합니다.
- 기존 코드를 건드리지 않기 때문에 코드는 간결해지고 기존코드가 복잡해 지지 않는다.

## 단점

- 각자의 역할을 나누다 보니 클래스가 늘어난다.

## 복습

- 팩토리 메소드 패턴을 적용했을 때의 장점과 단점은?
- "확장에 열려있고 변경에 닫혀있는 객체 지향 원칙"을 설명하시오
- Java 8에 추가된 default 메소드에 대해 설명하세요

## 실제로 Factory Method Pattern이 사용되는 곳
- java.lang.Calendar
- java.lang.NumberFormat
- Spring BeanFactory -> Object Type의 Product를 만드는 BeanFactory라는 Creator