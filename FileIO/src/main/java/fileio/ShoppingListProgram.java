package fileio;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingListProgram {

    public static String askForItemName(String action) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of an item to " + action + " your list or DONE");
        String item = keyboard.nextLine();
        return item;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Enter the name of your shopping list file");
        String fileName = keyboard.nextLine();

        // read the file
        File file = new File(fileName);
        if (file.exists()) {
            try {
                // opens the file for reading
                BufferedReader inputFile = new BufferedReader(new FileReader(file));

                // read the file
                String line = inputFile.readLine();
                while (line != null) { // at the end of the file, line becomes null
                    if (!line.isEmpty()) { // avoid the last blank line
                        list.add(line);
                        line = inputFile.readLine(); // read the next line
                    }
                }

                // close the file
                inputFile.close();

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        System.out.println("here's what's on your list: ");
        // display current list on screen
        for (String itemName : list) {
            System.out.println(itemName);
        }

        String item = askForItemName("remove from");
        while (!item.equalsIgnoreCase("done")) {
            list.remove(item);
            item = askForItemName("remove from");
        }

        item = askForItemName("add to");
        while (!item.equalsIgnoreCase("done")) {
            list.add(item);
            item = askForItemName("add to");
        }

        // Writing to a file
        try {
            // opens the file - it will create a file if it doesn't exist

            // print writer will OVERWRITE any existing file
            PrintWriter fileOutput =
                    new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            // add a true argument to FileWriter for append mode
            // PrintWriter fileOutput =
            //                    new PrintWriter(new BufferedWriter(new FileWriter("list.txt", true)));

            // write to the file
            for (String itemName : list) {
                fileOutput.println(itemName);
            }

            // close the file
            fileOutput.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
