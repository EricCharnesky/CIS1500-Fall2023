import java.util.Scanner;

public class Main {

    public static String getInputFromUser(String message) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(message);
        String command = keyboard.nextLine();
        return command;
    }

    public static String getCommandFromUser() {
        return getInputFromUser("Please enter a command");
    }

    public static String askUserToPlayAgain() {
        return getInputFromUser("Do you want to play again? y/n");
    }

    public static void printValidCommands() {
        System.out.println("You can't do that, please enter x+, x-, y+, y-, thrusters, self destruct, nothing");
    }

    public static void selfDestruct() {
        String command = "";
        while (!command.equalsIgnoreCase("1234")) {
            System.out.println("Self destruct sequence activated, please enter cancellation code to abort");
            command = getCommandFromUser();
        }
    }

    public static int randomNumberNegative10toPositive10() {
        int randomValue = (int) (Math.random() * 21) - 10;
        return randomValue;
    }

    public static boolean commandIsValid(String command) {
        return command.equalsIgnoreCase("x+") ||
                command.equalsIgnoreCase("x-") ||
                command.equalsIgnoreCase("y+") ||
                command.equalsIgnoreCase("y-") ||
                command.equalsIgnoreCase("thrusters") ||
                command.equalsIgnoreCase("self destruct") ||
                command.equalsIgnoreCase("nothing");
    }

    public static void printCrashOrLand(int xTilt, int yTilt) {
        if (xTilt != 0 || yTilt != 0) {
            System.out.println("You crashed the lunar lander! ( no humans were hurt )");
        } else {
            System.out.println("You landed successfully!");
        }
    }

    public static boolean hasNotLanded(int distanceFromSurface) {
        return distanceFromSurface > 0;
    }

    public static void main(String[] args) {

        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {

            int distanceFromSurface = 10;
            int xTilt = randomNumberNegative10toPositive10();
            int yTilt = randomNumberNegative10toPositive10();

            while (hasNotLanded(distanceFromSurface)) {
                System.out.println("You are " + distanceFromSurface + " distance from the surface," +
                        "your xTilt is " + xTilt + " and your yTilt is " + yTilt);

                String command = getCommandFromUser();
                if (commandIsValid(command)) {
                    distanceFromSurface--;
                    if (command.equalsIgnoreCase("x+")) {
                        xTilt++;
                    } else if (command.equalsIgnoreCase("x-")) {
                        xTilt--;
                    } else if (command.equalsIgnoreCase("y+")) {
                        yTilt++;
                    } else if (command.equalsIgnoreCase("y-")) {
                        yTilt--;
                    } else if (command.equalsIgnoreCase("thrusters")) {
                        distanceFromSurface += 2;
                    } else if (command.equalsIgnoreCase("self destruct")) {
                        selfDestruct();
                    }
                } else {
                    printValidCommands();
                }
            }
            printCrashOrLand(xTilt, yTilt);

            playAgain = askUserToPlayAgain();
        }

    }
}