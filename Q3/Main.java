package Prof.Q3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i <2 ; i++) {
            appleBox1.addFruit(new Apple());
            appleBox2.addFruit(new Apple());
        }
        for (int i = 0; i <4 ; i++) {
            appleBox1.addFruit(new Apple());
            orangeBox.addFruit(new Orange());
        }
        System.out.println("Вес коробки яблок " + appleBox1.getWeight() + " " + "вес коробки апельсинов " + orangeBox.getWeight());
        System.out.println(appleBox1.compare(orangeBox));
        appleBox1.dropFruitTo(appleBox2,1);
        appleBox1.getFruitAmount();
        appleBox2.getFruitAmount();
    }
}
