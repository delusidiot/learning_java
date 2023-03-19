package generic;

import generic.fruit.Grape;

public class Main {
    public static void main(String[] args) {
        Box<Grape> box = new Box<>(new Grape());
        Box<String> test = BoxFactory.makeBox("test");
        BoxFactory.peekBox2(box);
    }
}
