import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Human him = new Human("Isla", 20, 182);
       Human her = new Human(him);

        System.out.println(her.toString());
    }
}