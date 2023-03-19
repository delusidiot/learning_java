# Abstract Factory

서로 관련있는 여러 객체를 만들어주는 인터페이스
- 구체적으로 어떤 클래스의 인스턴스를(concrete product)를 사용하는지 감출 수 있다.
![abstract_factory](https://user-images.githubusercontent.com/65374355/178312548-a2b818c7-b502-4370-9b81-29f766270c66.png)


## Factory Method vs Abstract Factory
둘 다 구체적인 객체 생성 과정을 추상화한 인터페이스를 제공하는 효과와 모양은 비슷하지만 관점이 다르기 때문에 서로 다른 패턴으로 정의해 놓은 것입니다.

- Factory Method Pattern은 "팩토리를 구현하는 방법(inheritance)"에 초점을 둔다.
  - 객체를 만드는 과정
- Abstract Factory Pattern은 "팩토리를 사용하는 방법(composition)"에 초점을 둔다.
  - 팩토리를 사용하는 클라이언트 관점에서 팩토리를 통해 추상화된 인터페이스를 클라이언트가 사용할 수 있다.

목적 또한 조금 다릅니다.
- Factory Method Pattern은 구체적인 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것이 목적
- Abstract Factory Pattern은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적


## 실제 Abstract Factory Pattern이 사용되는 곳

### java library
- javax.xml.xpath.XPathFactory#newInstance()
- javax.xml.transform.TransformerFactory#newInstance()
- javax.xml.parsers.DocumentBuilderFactory#newInstance()

### Spring
- FactoryBean과 그 구현체