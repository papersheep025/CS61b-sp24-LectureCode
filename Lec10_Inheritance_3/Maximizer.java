package Lec10_Inheritance_3;

import java.util.Comparator;

public class Maximizer {

    public static Comparable max(Comparable[] items) {
        int maxDex = 0;

        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Sture", 9);
        Dog d3 = new Dog("Benjamin", 15);
        Dog[] dogs = new Dog[]{d1, d2, d3};

        Dog maxDog = (Dog) Maximizer.max(dogs);
        maxDog.bark();

        Dog d4 = new Dog("Stewie", 200);
        Dog d5 = new Dog("Xavior", 999999);

        Comparator<Dog> nc = Dog.getNameComparator();
        int cmp = nc.compare(d4, d5);
        if (cmp > 0) {
            d4.bark();
        } else {
            d5.bark();
        }
    }
}
