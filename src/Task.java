//decided to use LocalDate, will allow me to use date data easily
import java.util.LocalDate
class Task {
    private String name;
    private LocalDate dateTime;
    private String notes;

    //Constructor, initializes needed variables
    public Task(String name, LocalDate dateTime, String notes) {
        this.name = name;
        this.dateTime = dateTime;
        this.notes = notes;
    }

    //getters for my three variables
    public String getName() {
        return name;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public String getNotes() {
        return notes;
    }
}