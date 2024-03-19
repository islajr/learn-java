public class threads implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread running successfully.");
    }

    public static void main(String[] args) {
        Runnable r = new threads();

        Thread t = new Thread(r, "Hello!");

        // start thread
        t.start();

        // rest of the string implementation
        String s = t.getName();
        System.out.println(s);
    }
}