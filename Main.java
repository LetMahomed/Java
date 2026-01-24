// Imports the Scanner class for reading user input
import java.util.Scanner;

// Entry point of the Expense Tracker application
public class Main {

    public static void main(String[] args) {

        // Scanner used to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Creates an ExpenseManager to handle expenses
        ExpenseManager manager = new ExpenseManager();

        // Loads previously saved expenses from the file
        manager.loadFromFile(); // load saved data

        // Controls whether the program keeps running
        boolean running = true;

        // Main program loop
        while (running) {

            // Displays the main menu
            System.out.println("\nExpense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Reads the user's menu choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            // Executes the selected menu option
            switch (choice) {

                // Option 1: Add a new expense
                case 1:
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    // Creates a new Expense object and adds it to the manager
                    manager.addExpense(new Expense(amount, category, description));
                    break;

                // Option 2: Display all expenses
                case 2:
                    manager.displayExpenses();
                    break;

                // Option 3: Display the total amount spent
                case 3:
                    System.out.println("Total spent: $" + manager.calculateTotal());
                    break;

                // Option 4: Save expenses and exit the program
                case 4:
                    manager.saveToFile();
                    running = false;
                    System.out.println("Keep saving!");
                    break;

                // Handles invalid menu choices
                default:
                    System.out.println("Invalid option.");
            }
        }

        // Closes the scanner to free resources
        scanner.close();
    }
}
