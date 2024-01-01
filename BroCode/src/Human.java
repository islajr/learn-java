public class Human {
    private String name;
    private int age;
    private double height;

    Human(String name, int age, double height) {
        this.name = name;       // setName(name) would also work after the setter has been defined.
        this.age = age;
        this.height = height;
    }

    // defining getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    // defining setters
    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    // copy method
    public void copy(Human human2) {
        setName(human2.name);
        setAge(human2.age);
        setHeight(human2.height);
    }

    // overloading to string
    public String toString() {
        return ("I am " + this.name + ", " + age + " years old and " + height + " cm tall.");
    }
}