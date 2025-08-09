import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Expense{

    private LocalDate date;
    private double amount;
    private String category;
    private String description;

    public Expense(String date, String category, String description, double amount) {
    if (date == null || date.isEmpty() || category == null || category.isEmpty()) {
        throw new IllegalArgumentException("Date and category cannot be empty");
    }
    if (amount <= 0.0) {
        throw new IllegalArgumentException("Amount must be greater than zero.");
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
    this.date = LocalDate.parse(date, formatter);

    this.category = category;
    this.amount = amount;
    this.description = description;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getAmount(){
        return amount;
    }
    public String getCategory(){
        return category;
    }
    public String getDescription(){
        return description;
    }
    @Override
    public String toString(){
        return "Expense Details \n\nDate: "+ date +
                "\nCategory: "+ category+
                "\nAmount: "+ amount + 
                "\nDescription: " + description ;
    }

}
