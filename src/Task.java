//decided to use LocalDate, will allow me to use date data easily
import java.time.LocalDate;
public class Task {
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

    @Override
    public boolean equals(Object o) { // Overrides what it means for Task objects to be equal
        if (o instanceof Task t) {
            if (t.name.equals(name) && t.dateTime.equals(dateTime)) {  // Based on name and due date
                return true;
            }
        }
        return false;
    }


    public int compareTo(Object o) {
        if (o instanceof Task t) {
            return dateTime.compareTo(t.dateTime);  // Compares based on Due Date, useful in TaskList.java add function
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return name + "," + dateTime + "," + notes;
    }
}