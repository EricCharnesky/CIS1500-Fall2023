package fileio;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingListProgramWithClasses {

    public static Item askForItemName(String action) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of an item to " + action + " your list or DONE");
        String name = keyboard.nextLine();
        System.out.println("Enter the quantity");
        int quantity = Integer.parseInt(keyboard.nextLine());
        Item item = new Item(name, quantity);
        return item;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Item> list = new ArrayList<>();

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
                        String[] parts = line.split("\\|");
                        String name = parts[0];
                        int quantity = Integer.parseInt(parts[1]);
                        Item item = new Item(name, quantity);
                        list.add(item);
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
        for (Item item : list) {
            System.out.println(item.getQuantity() + " " + item.getName());
        }

        Item itemToRemove = askForItemName("remove from");
        while (!itemToRemove.getName().equalsIgnoreCase("done")) {
            // removing with .remove(itemToRemove) won't work very well with Item class instances, we have to do it the hard way
            for ( int index = 0; index < list.size(); index++ ){
                // compare the current item in the list loop with the item to remove
                if ( list.get(index).getName().equalsIgnoreCase(itemToRemove.getName())){
                    list.remove(index);
                }
            }

            itemToRemove = askForItemName("remove from");
        }

        Item itemToAdd = askForItemName("add to");
        while (!itemToAdd.getName().equalsIgnoreCase("done")) {
            list.add(itemToAdd);
            itemToAdd = askForItemName("add to");
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
            for (Item item : list) {
                fileOutput.println(item.getLineForFile());
            }

            // close the file
            fileOutput.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
