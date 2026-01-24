// Imports classes needed for file input and output
import java.io.*;

// Imports ArrayList for storing multiple Expense objects
import java.util.ArrayList;

// Manages a collection of expenses, including storage, display, and file handling
public class ExpenseManager {

    // Stores all expense objects in a dynamic list
    private ArrayList<Expense> expenses = new ArrayList<>();

    // Name of the file used to save and load expenses
    private final String FILE_NAME = "expenses.txt";

    // Adds a new expense to the list
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Displays all recorded expenses to the console
    public void displayExpenses() {
        // Checks if there are no expenses stored
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        // Loops through each expense and prints it
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    // Calculates and returns the total amount of all expenses
    public double calculateTotal() {
        double total = 0;

        // Adds each expense amount to the total
        for (Expense e : expenses) {
            total += e.getAmount(); 
        }

        return total;
    }

    // Saves all expenses to a text file
    public void saveToFile() {
        // Uses try-with-resources to automatically close the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Writes each expense in file-friendly format
            for (Expense e : expenses) {
                writer.println(e.toFileString());
            }
        } catch (IOException e) {
            // Handles any errors that occur while saving
            System.out.println("Error saving expenses.");
        }
    }

    // Loads expenses from a text file
    public void loadFromFile() {
        File file = new File(FILE_NAME);

        // If the file does not exist, exit the method
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Reads each line from the file
            while ((line = reader.readLine()) != null) {
                // Splits the line into parts using commas
                String[] parts = line.split(",");

                // Converts the stored values back into their original types
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                String description = parts[2];

                // Creates a new Expense object and adds it to the list
                expenses.add(new Expense(amount, category, description));
            }
        } catch (IOException e) {
            // Handles any errors that occur while loading
            System.out.println("Error loading expenses.");
        }
    }
}
