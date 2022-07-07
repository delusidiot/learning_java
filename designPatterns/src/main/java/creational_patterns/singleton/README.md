# Singleton Pattern

인스턴스를 오직 한개만 제공하는 클래스

<img width="200" alt="Singleton" src="https://user-images.githubusercontent.com/65374355/177692937-acb5d3dc-89ca-4e1f-8b58-73d5b5a45374.png">

시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우가 있습니다. 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요합니다.

## 간단한 Singleton

[Settings](./Settings.java)는 Singleton Pattern 을 만들기 위한 일반적인 방법입니다. 이 코드는 MultiThread 환경에서 안전하지 않습니다.

2가지 Thread `RED`와 `BLUE`가 있다고 가정하겠습니다. 먼저 `RED`가 getInstance()메소드를 실행하면서 if문에 진입하였을 때 객체가 생성되지 않은 타이밍에 `BLUE`가 getInstance()메소드의 if 문을 실행하면 결국 객체를 2번 생성하게 됩니다. 결국 `RED`와 `BLUE`의 Setting 인스턴스가 서로 다르게 됩니다.

## Thread Safe

### Synchronized

[SynchronizedSettings](./SynchronizedSettings.java)는 getInstance()에서 synchronized 키워드를 사용하여 Thread Safe하게 만든것입니다.
해당 방법은 동기화 처리과정에서 성능의 불이익이 있을 수 있습니다.

### Eager initialization

[EagerInitializationSettings](./EagerInitializationSettings.java)는 객체의 생성비용이 그렇게 많지 않을 때 그리고 굳이 프로그램 생성 이후에 객체를 생성할 필요가 없을 때 사용할 수 있는 방법입니다.

해당 방법은 미리 만든다는 그 자체가 단점이 될 수 있습니다. 해당 객체의 생성하는 과정이 복잡하고 시간이 걸리지만 생성해 놓고 사용하지 않는다면 해당 과정 자체가 리소스의 낭비로 이어집니다.

### Double-checked locking

[DoubleCheckedLockingSettings](./DoubleCheckedLockingSettings.java)는 instance를 필요로 하는 시점에 생성되는 형식으로 하기 위한 방법중 하나입니다. 처음 instance가 null인지 체크를 한 뒤 synchronized block에서 한번 더 체크를 하기 때문에 Double-checked locking이라고 불립니다.

이미 인스턴스가 있는 경우 getInstance()가 호출될때 마다 synchronized가 걸리지 않기 때문에 [SynchronizedSettings](./SynchronizedSettings.java)보다 효율적입니다.

java 1.5 부터 생긴 volatile 을 사용합니다.

### StaticInnerClassSettings

[StaticInnerClassSettings](./StaticInnerClassSettings.java) 위 방법중 가장 권장되는 방법입니다. 복잡한 과정을 필요로 하지 않고 instance를 필요로 하는 시점에 객체를 생성할 수 있습니다.

## Singleton 깨뜨리기

### Reflection

### 직렬화 역직렬화

해당 경우는 클래스에 Serializable을 implements해줘야 사용가능한 방법입니다.

해당 방법에슨 대응 방안이 있습니다. 역직렬화 할때 사용할 수 있는 메소드가 하나있는데 이것은 명시적으로 오버라이딩 가능한 것은 아닙니다. 실제 Serializable 인터페이스엔 없습니다.

### Reflection 깨짐 막기
사용하는 쪽에서 Reflection을 이용해서 싱글톤을 깬경우 싱글톤으로 사용하기를 포기하는것으로 여길 수 있지만 이마저도 막는 방법이 있습니다. 단순히 enum을 사용하면 됩니다.

Enum에서도 생성자(기본 private), 필드, 메소드를 넣을 수 있습니다.

Enum을 Reflection으로 객체를 생성하려고 하면 IllegalArgumentException이 발생합니다. 이는 Constructor에서 Modifier.ENUM을 제외한 것을 볼 수 있습니다.
```java
public final class Constructor<T> extends Executable {
    T newInstanceWithCaller(Object[] args, boolean checkAccess, Class<?> caller)
            throws InstantiationException, IllegalAccessException,
            InvocationTargetException
    {
        if (checkAccess)
            checkAccess(caller, clazz, clazz, modifiers);

        if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");

        ConstructorAccessor ca = constructorAccessor;   // read volatile
        if (ca == null) {
            ca = acquireConstructorAccessor();
        }
        @SuppressWarnings("unchecked")
        T inst = (T) ca.newInstance(args);
        return inst;
    }
}
```

단점은 미리 만들어 놓는다는 것입니다. 그리고 상속을 받지도 못합니다.

Enum은 기본적으로 Serializable을 구현하고 있습니다. 이는 enum이 실제로 보이진 않지만 Enum이라는 클래스를 상속받고 있기 때문인데 이는 bytecode를 직접 살펴봐야 알 수 있는 부분입니다. enum은 내부적으로 직렬화한뒤 역 직렬화 하더라도 같은 객체가 반화됩니다.

해당 2가지 단점 때문에 적용하지 못한다면 [StaticInnerClassSettings](./StaticInnerClassSettings.java)를 사용해야 합니다.

### 복습
- Java에서 enum을 사용하지 않고 싱글톤 패턴을 구현하는 방법은?
- private 생성자와 static 메소드를 사용하는 방법의 단점은?
- enum을 사용해 싱글톤 패턴을 구현하는 방법의 장점과 단점은?
- static inner 클래스를 사용해 싱글톤 패턴을 구현.

## 실제로 싱글톤 패턴이 사용되는곳

- Spring에서 Bean의 스코프 중하나로 SingletonScope
```java
public class SpringExample {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        String hello = ac.getBean("hello", String.class);
        String hello2 = ac.getBean("hello", String.class);
        System.out.println(hello == hello2);
    }
    static class SpringConfig {
        @Bean
        public String hello(){
            return "hello";
        }
    }
}
```
- java.lang.Runtime
```java
public class RuntimeExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("runtime = " + runtime.maxMemory());
        System.out.println("runtime = " + runtime.freeMemory());
    }
}
```
- 다른 디자인 패턴(빌더, 퍼사드, 추상팩토리 등)구현체의 일부로 쓰이기도 한다.
