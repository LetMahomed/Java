import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        manager.loadFromFile(); // load saved data

        boolean running = true;

        while (running) {
            System.out.println("\nExpense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    manager.addExpense(new Expense(amount, category, description));
                    break;

                case 2:
                    manager.displayExpenses();
                    break;

                case 3:
                    System.out.println("Total spent: $" + manager.calculateTotal());
                    break;

                case 4:
                    manager.saveToFile();
                    running = false;
                    System.out.println("Keep saving!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
