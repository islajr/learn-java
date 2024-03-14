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

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(newDemo);
            file.close();

            System.out.println("Object has been serialized.");
        }
        catch (IOException ex) {
            System.out.println("Caught IOException. ");
        }
    }
}