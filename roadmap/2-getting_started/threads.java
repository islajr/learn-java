public class threads extends Thread {

    // overriding the run() method of the super class
    @Override
    public void run() {
        System.out.println("This is my first thread!");
    }

    public static void main(String[] args) {
        threads thread = new threads();

        // .start() invokes the run() method.
        thread.start();
    }
}