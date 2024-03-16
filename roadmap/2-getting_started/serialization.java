import java.io.*;

class Demo implements Serializable {
    private static final long serialUID = 1234567890L;
    transient int a;
    static int b;
    String name;
    int age;

    Demo(int a, int b, String name, int age) {
        this.a = a;
        Demo.b = b;
        this.name = name;
        this.age = age;
    }
}

public class serialization {
    static void printData(Demo instance) {
        System.out.println("a: " + instance.a + ". ");
        System.out.println("b: " + Demo.b + ". ");
        System.out.println("name: " + instance.name + ". ");
        System.out.println("age: " + instance.age + ". ");
    }
    public static void main(String[] args) {
        Demo first = new Demo(1, 2 ,"Isla", 20);
        String filename = "subfile.txt";

        // serialization
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(first);

            file.close();
            out.close();

            System.out.println("Object has been serialized.");

            System.out.println("After Serialization...");
            printData(first);
            first = null;
            System.gc();

            Demo.b = 5;    // changing the value of the static variable

        }
        catch (IOException io) {
            System.out.println("IOException has been caught. ");
        }

        // de-serialization
        Demo second = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            second = (Demo) in.readObject();

            in.close();
            file.close();
            System.out.println("After Deserialization...");
            printData(second);
        }
        catch (IOException io) {
            System.out.println("IOException has been caught. ");
        }
        catch (ClassNotFoundException cl) {
            System.out.println("Check your UID! ");
        }
    }
}
