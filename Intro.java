class Dog {
    // instance variables
    int size;
    String breed;
    String name;

    // method
    void bark() {
        System.out.println("Ruff! Ruff!!");
    }

}

public class Intro {
    public static void main (String[] args) {
        Dog rodger = new Dog();
        rodger.size = 50;
        rodger.breed = "German Shepherd";
        rodger.bark();
    }
}