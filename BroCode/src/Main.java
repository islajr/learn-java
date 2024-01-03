import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal animal;

        System.out.print("What animal do you want? (d)og or (c)at ");
        String choice = scanner.next();

        switch (choice){
            case "d":
                animal = new Dog();
                animal.speak();
                break;
            case "c":
                animal = new Cat();
                animal.speak();
                break;
            default:
                System.out.println("Insert a recognized option! ");
                break;


        }
    }
}