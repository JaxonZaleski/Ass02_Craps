import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();
        Scanner in = new Scanner (System.in);
        int die1 = 0;
        int die2 = 0;
        int crapsRoll = 0;
        int finished = 0;
        boolean done = false;

        do {
            System.out.println("The game is starting!");
            System.out.println();
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You lost.");System.out.println("Die 1 = " + die1 + " | die 2 = " + die2);
                System.out.println();
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You won.");
                System.out.println("Die 1 = " + die1 + " | die 2 = " + die2);
                System.out.println();
            } else {
                System.out.println("Die 1 = " + die1 + " | die 2 = " + die2);
                do {
                    System.out.println("Trying for the point.");
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int thePoint = die1 + die2;
                    if (thePoint == crapsRoll) {
                        System.out.println("You made the point! You win!");
                        System.out.println("Die 1 = " + die1 + " | die 2 = " + die2);
                        finished = -1;
                    } else if (thePoint == 7) {
                        System.out.println("You got a seven. You lose!");
                        System.out.println("Die 1 = " + die1 + " | die 2 = " + die2);
                        finished = -1;
                    } else {
                        System.out.println("You didn't get anything.");
                        System.out.println("Die 1 = " + die1 + " | die 2 = " + die2);
                        System.out.println();
                        finished = 0;
                        finished = exit(finished, in);
                        System.out.println();
                        System.out.println();
                    }
                } while (finished != -1);
            }
            finished = 0;
            System.out.println("Game Over! Do you wish to quit or restart. Enter -1 to exit or any other whole number to continue.");
            done = false;
            do {
                if (in.hasNextInt()) {
                    finished = in.nextInt();
                    done = true;
                } else {
                    System.out.println("You must enter -1 or any other whole number.");
                }
            } while (!done);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        } while (finished != -1);
    }
    public static int exit(int complete, Scanner pipe) {

        boolean leave = false;
        complete = 0;

        System.out.println("Would you like to go for the point. Enter a number if yes. Enter -1 if no.");
        do {
            if (pipe.hasNextInt()) {
                complete = pipe.nextInt();
                pipe.nextLine();
                leave = true;
            } else {
                System.out.println("You must enter a number.");
                pipe.nextLine();
            }
        } while (!leave);
        return complete;
    }
}