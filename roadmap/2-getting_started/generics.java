import java.util.ArrayList;
import java.util.List;

public class generics {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) {
            myList.add(21 + i);
        }



        System.out.println(myList.size());
    }
}