public class exceptions {
    static void fun() {
        try {
            throw new NullPointerException("This is a fucking null pointer, dummy! ");
        }
        catch (NullPointerException e) {
//            System.out.println("Caught in the Fun method. ");
            System.out.println(e.getMessage());
            throw e;

        }
    }
    public static void main(String[] args) {
        try {
            fun();
        }
        catch (NullPointerException e) {
            System.out.println("Caught in main. ");
        }
    }
}