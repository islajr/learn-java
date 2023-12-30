public class Human {
    String name;
    int age;
    double height;

    Human(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void eat() {
        System.out.printf("%s is eating.\n", this.name);
    }

    void drink() {
        System.out.printf("%s is drinking.\n", this.name);
    }
}