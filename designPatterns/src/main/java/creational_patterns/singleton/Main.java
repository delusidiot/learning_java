package creational_patterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * author       : delusidiot
 * date         : 2022-07-07
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        checkSingletons();

        brokenSingleton();

//        Constructor<?>[] declaredConstructors = EnumSettings.class.getDeclaredConstructors();
//        for (Constructor<?> constructor1 : declaredConstructors) {
//            constructor1.setAccessible(true);
//            constructor1.newInstance();
//        }
    }

    private static void brokenSingleton() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException, ClassNotFoundException {
        System.out.println("Broken Singleton");
        System.out.println("Reflection");
        StaticInnerClassSettings broken = StaticInnerClassSettings.getInstance();
        Constructor<StaticInnerClassSettings> constructor = StaticInnerClassSettings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        StaticInnerClassSettings newInstance = constructor.newInstance();
        System.out.println(broken == newInstance);
        System.out.println("Serializable");
        TestSingleton testSingleton = TestSingleton.getInstance();
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(testSingleton);
        }

        TestSingleton readSettings = null;
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            readSettings = (TestSingleton) in.readObject();
        }
        System.out.println(testSingleton == readSettings);
    }

    private static void checkSingletons() {
        System.out.println("Singletons");
        Settings settings1 = Settings.getInstance();
        System.out.println(settings1 == Settings.getInstance());

        SynchronizedSettings settings2 = SynchronizedSettings.getInstance();
        System.out.println(settings2 == SynchronizedSettings.getInstance());

        EagerInitializationSettings settings3 = EagerInitializationSettings.getInstance();
        System.out.println(settings3 == EagerInitializationSettings.getInstance());

        DoubleCheckedLockingSettings settings4 = DoubleCheckedLockingSettings.getInstance();
        System.out.println(settings4 == DoubleCheckedLockingSettings.getInstance());

        StaticInnerClassSettings settings5 = StaticInnerClassSettings.getInstance();
        System.out.println(settings5 == StaticInnerClassSettings.getInstance());
    }

    public static class TestSingleton implements Serializable {
        private TestSingleton() {

        }

        private static class TestSingletonHolder {
            private static final TestSingleton INSTANCE = new TestSingleton();
        }

        public static TestSingleton getInstance() {
            return TestSingleton.TestSingletonHolder.INSTANCE;
        }

        // 역 직렬화 대응 방안
        protected Object readResolve() {
            return getInstance();
        }
    }
}
