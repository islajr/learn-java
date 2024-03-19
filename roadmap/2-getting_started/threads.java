public class threads {
    public static void main(String[] args) {
        Thread t = new Thread("Hello!");

        // start the thread with default run method.
        t.start();

        String name = t.getName();
        System.out.println(name);
    }
}