package fileio2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO2 {

    public static void main(String[] args) {
        String fileName = "transactions.txt";

        ArrayList<Transaction> transactions = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);

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
                        double amount = Double.parseDouble(parts[1]);
                        String date = parts[2];
                        Transaction transaction = new Transaction(name, amount, date);
                        transactions.add(transaction);
                        line = inputFile.readLine(); // read the next line
                    }
                }

                // close the file
                inputFile.close();

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        System.out.println("Here's your current transaction list:");
        for ( Transaction transaction : transactions){
            System.out.println(transaction.getAccountName() + " $" + transaction.getAccountName()
                    + " on " + transaction.getDate());
        }

//      same as above with looping by index
//        for ( int index = 0; index < transactions.size(); index++ ){
//            Transaction transaction = transactions.get(index);
//            System.out.println(transaction.getAccountName() + " $" + transaction.getAccountName()
//                    + " on " + transaction.getDate());
//        }

        System.out.println("Please enter an account name or DONE");
        String accountName = keyboard.nextLine();

        while (!accountName.equalsIgnoreCase("done")) {
            System.out.println("Enter the transaction amount");
            double amount = Double.parseDouble(keyboard.nextLine());

            System.out.println("Enter the transaction date");
            String date = keyboard.nextLine();

            Transaction transaction = new Transaction(accountName, amount, date);
            transactions.add(transaction);

            System.out.println("Please enter an account name or DONE");
            accountName = keyboard.nextLine();
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
            for (Transaction transaction : transactions) {
                fileOutput.println(transaction.getStringForFile());
            }

            // close the file
            fileOutput.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
