import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<String> food = new ArrayList<String>();
        food.add("Cupcakes");
        food.add("Malt");
        food.add("Pizza");

        for (int i = 0; i < food.size(); i++) {
            System.out.println(food.get(i));
        }*/

        ArrayList<ArrayList<String>> groceryList = new ArrayList<ArrayList<String>>();

        ArrayList<String> bakeryList = new ArrayList<String>();
        bakeryList.add("Pasta");
        bakeryList.add("Garlic Bread");
        bakeryList.add("Doughnuts");

        ArrayList<String> produceList = new ArrayList<String>();
        produceList.add("Tomatoes");
        produceList.add("Peppers");
        produceList.add("Zuccini");

        ArrayList<String> drinksList = new ArrayList<String>();
        drinksList.add("Soda");
        drinksList.add("Coffee");

        groceryList.add(bakeryList);
        groceryList.add(produceList);
        groceryList.add(drinksList);

        System.out.println(groceryList);
        System.out.println(groceryList.get(1));
    }
}