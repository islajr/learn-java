public class Human {
    String name;
    int age;
    double height;

    static int headCount;       // testing the static keyword.

    Human(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
        ++headCount;
    }

    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Human(String name) {
        this.name = name;
    }

    void eat() {
        System.out.printf("%s is eating.\n", this.name);
    }

    void drink() {
        System.out.printf("%s is drinking.\n", this.name);
    }

    public String toString() {
        return this.name + " is eating and drinking.";
    }
}