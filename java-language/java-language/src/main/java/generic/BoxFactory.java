package generic;

import generic.fruit.Fruit;

public class BoxFactory {
    public static <T> Box<T> makeBox(T o) {
        Box<T> box = new Box<T>(o);
        return box;
    }
    public static void peekBox(Box<Object> box) {

    }

    public static <T> void peekBox2(Box<T> box) {

    }
}
