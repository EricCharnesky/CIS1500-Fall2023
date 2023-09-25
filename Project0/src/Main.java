import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is the length of your horse fence?");
        int length = Integer.parseInt(keyboard.nextLine());
        System.out.println("What is the width of your horse fence?");
        int width = Integer.parseInt(keyboard.nextLine());

        System.out.println("How far apart do you want your posts?");
        int postDistance = Integer.parseInt(keyboard.nextLine());

        if ( length % postDistance != 0 || width % postDistance != 0 ){
            System.out.println("Invalid post distance, please try again");
        }

        System.out.println("How long of a board are you going to buy?");
        int boardLength = Integer.parseInt(keyboard.nextLine());

        if ( boardLength < postDistance ){
            System.out.println("Your boards aren't long enough, please try again");
        }

        int perimeter = length*2 + width*2;
        int numberOfPostsNeeded = perimeter / postDistance;

        int postsPerBoard = boardLength / postDistance;

        System.out.println("How many boards do you want across each post?");
        int numberOfBoardsGoingAcross = Integer.parseInt(keyboard.nextLine());

        int numberOfBoardsNeeded = ( numberOfPostsNeeded * numberOfBoardsGoingAcross ) / postsPerBoard;

        if ( ( numberOfPostsNeeded * numberOfBoardsGoingAcross ) % postsPerBoard != 0 ){
            numberOfBoardsNeeded += 1;
        }

        System.out.println("How much does a post cost?");
        double postCost = Double.parseDouble(keyboard.nextLine()) * numberOfPostsNeeded;

        System.out.println("How much does a board cost?");
        double boardCost = Double.parseDouble(keyboard.nextLine()) * numberOfBoardsNeeded;

        double grandTotal = postCost + boardCost;


        System.out.println("You need to buy " + numberOfPostsNeeded + " posts");
        System.out.println("You need to buy " + numberOfBoardsNeeded + " boards");

        System.out.println("It will cost $" + postCost + " for posts");
        System.out.println("It will cost $" + boardCost + " for boards");

        System.out.println("All together, the fence will cost $" + grandTotal);
    }
}