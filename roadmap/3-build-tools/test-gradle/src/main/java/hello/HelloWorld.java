package hello;
import org.joda.time.LocalTime;

public class HelloWorld {
    public static void main(String[] args) {
       LocalTime currentTime = new LocalTime();
       System.out.println("the current local time is " + currentTime);

       Greeter greet = new Greeter();
       System.out.println(greet.sayHello());
    }
}
