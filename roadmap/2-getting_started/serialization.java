import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class Demo implements Serializable {
    int a;
    String b;
    Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

public class serialization {
    public static void main(String[] args) {

        Demo newDemo = new Demo(92, "Archer");
        String filename = "file.ser";

        // Serialization Process
        try {
            FileOutputStream file = new FileOutputStream(filename); // first conversion step
            ObjectOutputStream out = new ObjectOutputStream(file);  // final conversion step

            out.writeObject(newDemo);   // method for serialization
            file.close();   // courtesy closing.

            System.out.println("Object has been serialized.");
        }
        catch (IOException ex) {
            System.out.println("Caught IOException. ");
        }
    }
}