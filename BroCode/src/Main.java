import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Human him = new Human("Isla", 20, 182);
        Human her = new Human("Mum", 45);

        him.eat();
        him.drink();

        her.eat();
        her.drink();

    }
}