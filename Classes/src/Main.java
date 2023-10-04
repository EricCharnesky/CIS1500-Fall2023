import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Chair ericsChair = new Chair("black", true,
                30, 20, 40 );
        printChairDetails(ericsChair, "Eric");

        ericsChair.adjustChairHeight(5);
        printChairDetails(ericsChair, "Eric");
        ericsChair.adjustChairHeight(-10);
        printChairDetails(ericsChair, "Eric");
        ericsChair.adjustChairHeight(100);
        printChairDetails(ericsChair, "Eric");
        ericsChair.adjustChairHeight(-100);
        printChairDetails(ericsChair, "Eric");

        Chair jebsChair = new Chair("grey", false, 30,
                30, 30);
        printChairDetails(jebsChair, "Jeb");

    }

    public static void printChairDetails(Chair chair, String ownersName){
        // this will crash on null value for color
        if ( chair.getColor().equalsIgnoreCase("black") ){
            System.out.println("Cool chair!");
        }
        // this won't crash, but black never equals null
        if ( "black".equalsIgnoreCase(chair.getColor()) ){
            System.out.println("Cool chair!");
        }
        System.out.println(ownersName + "'s chair color is: " + chair.getColor());
        System.out.println(ownersName + "'s chair has arms: " + chair.hasArms());
        System.out.println(ownersName + "'s chair height in cm is: " + chair.getHeightInCentimeters());

    }
}