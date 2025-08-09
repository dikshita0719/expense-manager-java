import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenseList;

    public ExpenseManager() {
        expenseList = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenseList.remove(expense);
    }

    public List<Expense> filterByCategory(String category) {
        List<Expense> categoryList = new ArrayList<>();
        for (Expense expense : expenseList) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                categoryList.add(expense);
            }
        }
        return categoryList;
    }

    public List<Expense> filterByDateRange(LocalDate start, LocalDate end) {
        List<Expense> sortedByDate = new ArrayList<>();
        for (Expense expense : expenseList) {
            LocalDate date = expense.getDate();
            if ((date.isEqual(start) || date.isAfter(start)) &&
                    (date.isEqual(end) || date.isBefore(end))) {
                sortedByDate.add(expense);
            }
        }
        return sortedByDate;
    }

    public List<Expense> getAllExpenses() {
        return expenseList;
    }
}
