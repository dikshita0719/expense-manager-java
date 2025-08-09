import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Filter by Category");
            System.out.println("4. Filter by Date Range");
            System.out.println("5. Remove Expense");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter date (dd-MM-yyyy): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    try {
                        Expense expense = new Expense(date, category, description, amount);
                        manager.addExpense(expense);
                        System.out.println("Expense added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    List<Expense> allExpenses = manager.getAllExpenses();
                    if (allExpenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        allExpenses.forEach(exp -> System.out.println(exp));
                    }
                    break;

                case "3":
                    System.out.print("Enter category: ");
                    String filterCategory = scanner.nextLine();
                    List<Expense> categoryExpenses = manager.filterByCategory(filterCategory);
                    categoryExpenses.forEach(exp -> System.out.println(exp));
                    break;

                case "4":
                    System.out.print("Enter start date (dd-MM-yyyy): ");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Enter end date (dd-MM-yyyy): ");
                    LocalDate endDate = LocalDate.parse(scanner.nextLine(), formatter);
                    List<Expense> dateFiltered = manager.filterByDateRange(startDate, endDate);
                    dateFiltered.forEach(exp -> System.out.println(exp));
                    break;

                case "5":
                    // Optional: Add logic to remove an expense by index or ID
                    break;

                case "6":
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
