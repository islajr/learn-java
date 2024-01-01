import java.util.Random;

public class Randoms {
    public static void main(String[] args) {
        Random random = new Random();
        int x = random.nextInt(0, 7);
        double y = random.nextDouble();
        System.out.println(y);
    }
}

/* NOTES
* The 'random' class is contained in the java.util package, and it is used to generate pseudo-random numbers.
* The difference between truly random and pseudo-random numbers is not clear to me at this point but the purpose is the same.
*
* To use this class, an instance of the random class has to be created and intialised, and it is done as follows:
* Random random = new Random();     // the parenthesis is a key part of instantialisation.
* random.nextInt() produces a random 'long' value and limits can be applied by inserting values in the parenthesis.
*
* random.nextDouble() returns a random digit as a double between 0 and 1.
* random.nextBoolean() returns a random choice of either true or false.
*
* */
