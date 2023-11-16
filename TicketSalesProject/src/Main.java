import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void writeTicketsToFile(String fileName, ArrayList<Ticket> tickets) {
        try {

            // it would be good to check if the file exists already

            PrintWriter fileOutput =
                    new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            for (Ticket ticket : tickets) {
                fileOutput.println(ticket.getStringForFile());
            }

            fileOutput.close();

        } catch (IOException e) {
            System.out.println("Unable to write the file!");
        }
    }

    public static void main(String[] args) {
        String option = "";
        Scanner keyboard = new Scanner(System.in);

        while (!option.equalsIgnoreCase("done")) {
            System.out.println("Enter option:" +
                    "\n\t1 - setup show" +
                    "\n\t2 - sell tickets " +
                    "\n\t3 - print report" +
                    "\n\tdone");

            option = keyboard.nextLine();

            if (option.equals("1")) {
                String showName = getShowName(keyboard);

                System.out.println("How many tickets do you want to sell?");
                int numberOfTickets = Integer.parseInt(keyboard.nextLine());
                ArrayList<Ticket> tickets = new ArrayList<>();
                for (int ticketNumber = 1; ticketNumber <= numberOfTickets; ticketNumber++) {
                    tickets.add(new Ticket(ticketNumber, "", 0));
                }

                writeTicketsToFile(showName, tickets);

            } else if (option.equals("2")) {
                String showName = getShowName(keyboard);

                File file = new File(showName);

                if (file.exists()) {
                    ArrayList<Ticket> tickets = new ArrayList<>();
                    try {
                        // opens the file for reading
                        BufferedReader inputFile = new BufferedReader(new FileReader(file));

                        // read the file
                        String line = inputFile.readLine();
                        while (line != null) { // at the end of the file, line becomes null
                            if (!line.isEmpty()) { // avoid the last blank line
                                String[] parts = line.split("\\|");
                                int ticketNumber = Integer.parseInt(parts[0]);
                                String purchaserName = parts[1];
                                int verificationCode = Integer.parseInt(parts[2]);
                                Ticket ticket = new Ticket(ticketNumber, purchaserName, verificationCode);
                                tickets.add(ticket);
                                line = inputFile.readLine(); // read the next line
                            }
                        }

                        Ticket ticket = new Ticket(0, "", 1);

                        while (ticket.verificationCode != 0) {
                            System.out.println("What ticket # do you want to buy?");
                            int ticketNumber = Integer.parseInt(keyboard.nextLine());

                            ticket = tickets.get(ticketNumber - 1);

                            if (ticket.verificationCode != 0) {
                                System.out.println("Sorry that ticket has already been sold");
                            }
                        }

                        System.out.println("What is your name?");
                        String name = keyboard.nextLine();
                        int verificationCode = (int) (Math.random() * 900_000 + 100_000);

                        ticket.setPurchaserName(name);
                        ticket.setVerificationCode(verificationCode);

                        System.out.println("Your verification code is " + verificationCode);

                        writeTicketsToFile(showName, tickets);

                    } catch (IOException e) {
                        System.out.println("Error reading file!");
                    }
                } else {
                    System.out.println("We don't sell tickets for that show");
                }
            } else if (option.equals("3")) {
                String showName = getShowName(keyboard);

                File file = new File(showName);

                if (file.exists()) {
                    BufferedReader inputFile = null;
                    try {
                        inputFile = new BufferedReader(new FileReader(file));

                        System.out.println("Ticket # | Purchaser Name | Verification Code");

                        // read the file
                        String line = inputFile.readLine();
                        while (line != null) { // at the end of the file, line becomes null
                            if (!line.isEmpty()) { // avoid the last blank line
                                System.out.println(line);
                                line = inputFile.readLine(); // read the next line
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read file!");
                    }

                } else {
                    System.out.println("We don't sell tickets for that show");
                }

            }


        }
    }

    private static String getShowName(Scanner keyboard) {
        System.out.println("What is the name of the show?");
        String showName = keyboard.nextLine();
        return showName;
    }
}