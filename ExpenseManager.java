import java.io.*;
import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Expense> expenses = new ArrayList<>();
    private final String FILE_NAME = "expenses.txt";

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public double calculateTotal() {
        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount(); 
        }

        return total;
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                writer.println(e.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                String description = parts[2];

                expenses.add(new Expense(amount, category, description));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses.");
        }
    }
}
