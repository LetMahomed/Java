public class Expense {
    private double amount;
    private String category;
    private String description;

    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String toFileString() {
        return amount + "," + category + "," + description;
    }

    @Override
    public String toString() {
        return "Amount: $" + amount + " | Category: " + category + " | Description: " + description;
    }
}
