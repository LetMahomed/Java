// Represents a single expense entry
public class Expense {

    // Stores the amount of money spent
    private double amount;

    // Stores the category of the expense 
    private String category;

    // Stores a short description of the expense
    private String description;

    // Constructor that initializes an Expense object with amount, category, and description
    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    // Returns the amount of the expense
    public double getAmount() {
        return amount;
    }

    // Returns a comma-separated string used for saving the expense to a file
    public String toFileString() {
        return amount + "," + category + "," + description;
    }

    // Overrides the default toString method to provide a readable format for display
    @Override
    public String toString() {
        return "Amount: $" + amount + " | Category: " + category + " | Description: " + description;
    }
}
