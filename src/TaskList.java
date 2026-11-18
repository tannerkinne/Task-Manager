import java.util.ArrayList;
import java.io.*;
class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("list.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);

                String name = parts[0];
                LocalDate date = LocalDate.parse(parts[1]);
                String notes = parts[2];

                tasks.add(new Task(name, date, notes));
            }

        } catch (FileNotFoundException e) {
            //no list yet
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Task t) {
        for (int i = 0; i < tasks.size(); i++) {
            if (t.compareTo(tasks.get(i)) < 0) {
                tasks.add(i, t);
                return;
            }
        }
        tasks.add(t);
    }

    public void delete(Task t) {
        tasks.remove(t);
    }

    public void print() {
        IO.println("Task List");
        IO.println("Name,Due Date,Notes");
        for (Task t : tasks) {
            IO.println(t.toString());
        }
    }

    public void save() {
        try (PrintWriter pw = new PrintWriter("list.csv")) {
            for (Task t : tasks) {
                pw.println(t.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}