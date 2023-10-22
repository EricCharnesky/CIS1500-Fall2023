package arraysandarraylists;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        while ( !game.isGameOver()){
            game.printBoard();
            System.out.println(game.getCurrentPlayer() + "'s turn");
            System.out.println("Pick a row");
            int rowIndex = Integer.parseInt(keyboard.nextLine());
            System.out.println("Pick a column");
            int columnIndex = Integer.parseInt(keyboard.nextLine());
            if ( !game.mark(rowIndex, columnIndex)){
                System.out.println("Invalid choice, try again");
            }
        }
        System.out.println("Game over!");
        game.printBoard();





        // [] mean array, = new type[size]
        int[] midtermscores = new int[17];

        // the first item of the 17 is at index 0 - at index 0 == [0]
        midtermscores[0] = 100;
        midtermscores[1] = 97;

        // looping through arrays - they have indexes 0 - the length ( not including )
        for (int index = 0; index < midtermscores.length; index++) {
            midtermscores[index] = (int) (Math.random() * 41) + 60;
        }

        // the first is the largest, until we know otherwise
        int highestScore = midtermscores[0];
        int lowestScore = midtermscores[0];

        double totalScore = 0;

        // enhanced for loop is READ ONLY
        // each value in midtermscores will be referred to as score in the loop
        for (int score : midtermscores) {
            System.out.println(score);
            if (score > highestScore) {
                highestScore = score;
            }
            if (score < lowestScore) {
                lowestScore = score;
            }
            totalScore += score;
        }

        System.out.println("Highest score: " + highestScore);
        System.out.println("Lowest score: " + lowestScore);
        System.out.println("Average score: " + totalScore / midtermscores.length);

        // arrays of reference types will default to NULL - danger danger
        String[] names = new String[8];
        names[0] = "Eric";
        names[1] = "Jasmine";
        names[2] = "Joy";
        names[3] = "Jeb";
        names[4] = "Jenavieve";
        names[5] = "Journey";
        names[6] = "Jubilee";
        names[7] = "Jackson";

        // read only loop, won't change the values in the array
        for (String name : names) {
            name = name.toUpperCase();
            System.out.println(name);
        }

        for (String name : names) {
            System.out.println(name);
        }

        // can't use primitive types, Integer, Double - no need to declare a size
        ArrayList<Integer> scores = new ArrayList<>();
        int score = 0;



        while (score != -1) {
            System.out.println("Please enter a score or -1 to stop");
            score = Integer.parseInt(keyboard.nextLine());
            if (score != -1) {
                scores.add(score);
            }
        }
        // scores[0] for arrays
        int highestArrayListScore = scores.get(0);
        int lowestArrayListScore = scores.get(0);
        double totalArrayListScores = 0;

        for (int arrayListScore : scores) {
            if (arrayListScore > highestArrayListScore) {
                highestArrayListScore = arrayListScore;
            }
            if (arrayListScore < lowestArrayListScore) {
                lowestArrayListScore = arrayListScore;
            }
            totalArrayListScores += arrayListScore;
        }

        System.out.println("Highest array list score: " + highestArrayListScore);
        System.out.println("Lowest array list score: " + lowestArrayListScore);
        // use .size() instead of .length
        System.out.println("Average array list score: " + totalArrayListScores / scores.size() );


        ArrayList<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("Eric");
        namesArrayList.add("Sonic");
        namesArrayList.remove("Eric");
        namesArrayList.remove(0);

        // arrays will start with default values in the size you specify
        int[][] twoDimensionalArray = new int[3][3];

        // arrayvariable [row][column]
        twoDimensionalArray[0][0] = 1;
        twoDimensionalArray[0][1] = 2;
        twoDimensionalArray[0][2] = 3;

        twoDimensionalArray[1][0] = 4;
        twoDimensionalArray[1][1] = 5;
        twoDimensionalArray[1][2] = 6;

        twoDimensionalArray[2][0] = 7;
        twoDimensionalArray[2][1] = 8;
        twoDimensionalArray[2][2] = 9;






    }
}
