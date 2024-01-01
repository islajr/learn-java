import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Human him = new Human("Isla", 20, 182);
       Human her = new Human("Victoria", 19, 167);

        System.out.println(her.toString());

       // copying the attributes of 'him'
       her.copy(him);
        System.out.println(her.toString());
    }
}