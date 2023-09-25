import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String play = askTheUserIfTheyWantToPlay();

        while (play.equalsIgnoreCase("y")) {

            int highestNumber = askHowHighToGuess();

            int randomNumber = (int) (Math.random() * highestNumber + 1);

            int guess = askForAGuess(highestNumber);
            int numberOfGuesses = 1;

            while (guess != randomNumber) {
                printTooHighOrTooLow(guess, randomNumber);
                guess = askForAGuess(highestNumber);
                numberOfGuesses++;
            }

            System.out.println("Great guessing, you got it in "
                    + numberOfGuesses + " guesses!");

            play = askTheUserIfTheyWantToPlay();
        }

        printHaveANiceDay();
    }

    // void methods don't return values, they just run
    public static void printHaveANiceDay() {
        System.out.println("Have a great snow day!");
        System.out.println("Enjoy the sunshine!");
        System.out.println("Are you going to go sledding?");
    }

    // if it isn't void, tell the java what type of value is going to be returned
    public static String askTheUserIfTheyWantToPlay() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you want to play a game? (y/n)");
        String play = keyboard.nextLine();
        return play;
    }

    public static int askHowHighToGuess() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How high of a number do you want to guess?");
        int highestNumber = Integer.parseInt(keyboard.nextLine());
        return highestNumber;
    }

    // values defined to be passed are parameters
    public static int askForAGuess(int highestNumber) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            // try something that might crash
            try {
                System.out.println("Guess a number 1 - " + highestNumber);
                // if an exception happens, the code stops running and jumps to the catch
                int guess = Integer.parseInt(keyboard.nextLine());

                // return is skipped if there is an exception
                return guess;
            } // but don't crash, do this instead
            catch (NumberFormatException exception) {
                System.out.println("Please enter only numeric values");
            }
        }
    }

    // if you have more than 1 parameter, just comma spearate them
    public static void printTooHighOrTooLow(int guess, int randomNumber) {
        // primitive types are passed by value, so you get a copy
        randomNumber = 42; // won't change the value in main
        if (guess < randomNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
    }
}