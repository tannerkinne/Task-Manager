import java.time.LocalDate;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskList taskList = new TaskList();

        boolean running = true;

        while (running) {
            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. View tasks");
            System.out.println("2. Add task");
            System.out.println("3. Delete task");
            System.out.println("4. Save tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine(); //clear newline

            switch (choice) {
                case 1:
                    taskList.print();
                    break;

                case 2:
                    System.out.print("Enter task name: ");
                    String name = input.nextLine();

                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(input.nextLine());

                    System.out.print("Enter notes: ");
                    String notes = input.nextLine();

                    Task newTask = new Task(name, date, notes);
                    taskList.add(newTask);

                    System.out.println("Task added!");
                    break;

                case 3:
                    System.out.print("Enter task name to delete: ");
                    String deleteName = input.nextLine();

                    System.out.print("Enter task due date (YYYY-MM-DD): ");
                    LocalDate deleteDate = LocalDate.parse(input.nextLine());

                    Task deleteTask = new Task(deleteName, deleteDate, "");
                    taskList.delete(deleteTask);

                    System.out.println("Task deleted (if it existed).");
                    break;

                case 4:
                    taskList.save();
                    System.out.println("Tasks saved!");
                    break;

                case 5:
                    taskList.save();
                    System.out.println("Tasks saved. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        input.close();
    }
}