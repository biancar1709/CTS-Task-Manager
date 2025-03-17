package ro.ase.cts.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Task> tasks = new ArrayList<Task>();
    private static List<User> users = new ArrayList<>();
    private static User currentUser;
    private static List<Task> currentUserTasks = new ArrayList<>();

    public  void mainCLI() {
        while (true) {
            System.out.println("\nTask Manager CLI");
            System.out.println("1. Create User");
            System.out.println("2. Choose User");
            System.out.println("3. Create Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createUser();
                case 2 -> chooseUser();
                case 3 -> createTask();
                case 4 -> viewTasks();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createUser() {
        System.out.println("Creating New User");
        String userName = scanner.nextLine();
        currentUser = new User(userName);
         users.add(currentUser);
        System.out.println('\n');

        for (User u : users) {
            System.out.println(u);
        }

    }

    private void chooseUser(){
        System.out.println("Choose User");
        for (User user : users) {
            System.out.println(user);
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        currentUser = users.get(choice-1);

        currentUserTasks = new ArrayList<>();
        for (Task task : tasks) {
            if(task.getOwnerID() == currentUser.getUserID()){
                currentUserTasks.add(task);
            }
        }
        System.out.println("Current user: " + currentUser.getUserName() );
    }

    private static void createTask() {
        if (currentUser == null) {
            System.out.println("No user selected. Choose a user first.");
            return;
        }
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter task description: ");
        String taskDescription = scanner.nextLine();

        Task t = new Task(taskName, taskDescription, currentUser.getUserID());
       tasks.add(t);
       currentUserTasks.add(t);

        System.out.println("Task added for " + currentUser.getUserName());
    }

    private static void viewTasks() {
        if (currentUser == null) {
            System.out.println("No user selected. Choose a user first.");
            return;
        }
        if (currentUserTasks.isEmpty()) {
            System.out.println("No tasks available for " + currentUser.getUserName());
        } else {
            System.out.println("Tasks for " + currentUser.getUserName() + ":");
           for (Task task : currentUserTasks) {
               System.out.println(task);
           }
        }
    }
}
