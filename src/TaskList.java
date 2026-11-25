import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;
public class TaskList {
    public ArrayList<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("list.csv"))) {  // Opens a buffered reader to read list.csv
            String line;

            while ((line = br.readLine()) != null) {  // Creates a task object for every line
                String[] parts = line.split(",", 3);

                String name = parts[0];
                LocalDate date = LocalDate.parse(parts[1]);
                String notes = parts[2];

                tasks.add(new Task(name, date, notes));
            }

        } catch (FileNotFoundException e) {
            // Do nothing if there is no list yet
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Task t) {
        for (int i = 0; i < tasks.size(); i++) {
            if (t.compareTo(tasks.get(i)) < 0) {  // Based on Due Date, adds the task once it is in the correct location
                tasks.add(i, t);
                return;
            }
        }
        tasks.add(t);
    }

    public void delete(Task t) {
        tasks.remove(t);
    }

    public void print() {  // Creates an easily readable print function for TaskList
        System.out.println("Task List");
        System.out.println("Name,Due Date,Notes");
        for (Task t : tasks) {
            System.out.println(t.toString());
        }
    }

    public void save() {
        try (PrintWriter pw = new PrintWriter("list.csv")) {  // Saves the list to list.csv, allowing to recall later in new run
            for (Task t : tasks) {
                pw.println(t.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}