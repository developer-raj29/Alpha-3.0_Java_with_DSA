public class Abstraction {
    public static void main(String[] args) {
        // Mustang myhorse = new Mustang();

        Horse H = new Horse();
        H.eat();
        H.walk();
        // H.color;
        System.out.println(H.color);

        // Chicken c = new Chicken();
        // c.eat();
        // c.walk();

    }
}

// Parent or Base class
abstract class Animal {
    String color;

    Animal() {
        color = "Brown";
        System.out.println("Animal constructor called...");
    }

    // non abstract function
    void eat() {
        System.out.println("Animal Eats...");
    }

    // abstract function
    abstract void walk();
}

// child or drived class
class Horse extends Animal {
    // constructor
    Horse() {
        System.out.println("Horse constructor called...");

    }

    void changecolor() {
        color = "Dark Brown";
    }

    void walk() {
        System.out.println("Horse walk on 4 legs.....");
    }
}

// child or drived class
class Mustang extends Horse {

    Mustang() {
        System.out.println("Mustang constructor called...");
    }
}

// child or drived class
class Chicken extends Animal {

    void changecolor() {
        color = "Yellow";
    }

    void walk() {
        System.out.println("Chicken walk on 2 legs.....");
    }
}