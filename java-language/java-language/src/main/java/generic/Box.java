package generic;

import generic.fruit.Fruit;

public class Box<T> {
    private T ob;

    public Box(T ob) {
        this.ob = ob;
    }
    public T getOb() {
        return ob;
    }
}
