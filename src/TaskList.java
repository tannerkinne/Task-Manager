import java.util.ArrayList;
class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
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
        IO.println("Name | Due Date | Notes");
        for (Task t : tasks) {
            IO.println(t.toString());
        }
    }
}