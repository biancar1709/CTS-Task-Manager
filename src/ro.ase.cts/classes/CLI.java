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

    public void mainCLI() {
        System.out.println("\nTask Manager CLI");
        while (true) {
            if (currentUser != null) {
                System.out.println("1. Create User");
                System.out.println("2. Choose User");
                System.out.println("3. Create Task");
                System.out.println("4. View Tasks");
                System.out.println("5. Delete task");
                System.out.println("6. Update task");
                System.out.println("7. Unhide task");
                System.out.println("8. Filter tasks");

                System.out.println("9. Exit");

                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> createUser();
                    case 2 -> chooseUser();
                    case 3 -> createTask();
                    case 4 -> viewTasks();
                    case 5 -> {
                        if (currentUser.getUserType().equals("admin")) {
                            deleteTask();
                        } else {
                            hideTask();
                        }
                    }
                    case 6 -> updateTask();
                    case 7 -> unhideTask();
                    case 8 -> filterTasksByCriteria();
                    case 9 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } else {
                System.out.println("1. Create User");
                System.out.println("9. Exit");

                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> createUser();
                    case 9 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }

        }
    }

    private void unhideTask() {
        List<Task> tasksList = null;
        if (currentUser.getUserType().equals("admin")) {
            tasksList = tasks;
        } else if (currentUser.getUserType().equals("regular")) {
            tasksList = currentUserTasks;
        }

        int counter = 0;
        for (Task task : tasksList) {
            counter++;
            System.out.println(counter + ". " + task);
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 0) return;
        Task unhideableTask = tasksList.get(choice - 1);
        unhideableTask.setHidden(false);

        System.out.println("Select task to unhide or 0 to exit \n");
    }


    private void createUser() {
        System.out.println("Creating New User");
        System.out.print("Enter user name: ");

        String userName = scanner.nextLine();
        currentUser = new User(userName);
        users.add(currentUser);
        System.out.println('\n');

        for (User u : users) {
            System.out.println(u);
        }

    }

    private void deleteTask() {
        if (currentUser.getUserType().equals("admin")) {

            System.out.println("Select task to remove or 0 to exit \n");

            int counter = 0;
            for (Task task : tasks) {
                counter++;
                System.out.println(counter + ". " + task);
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            Task removableTask = tasks.get(choice - 1);

            tasks.remove(removableTask);

            System.out.println("Deleting task");
        }
    }

    private void hideTask() {
        if (currentUser.getUserType().equals("regular")) {

            System.out.println("Select task to hide or 0 to exit \n");

            int counter = 0;
            for (Task task : currentUserTasks) {
                counter++;
                System.out.println(counter + ". " + task);
            }
            int choice = scanner.nextInt();
            Task hideableTask = currentUserTasks.get(choice - 1);

            hideableTask.setHidden(true);

            System.out.println("Deleting task");
        }
    }


    private void updateTask() {
        Task updateableTask = null;
        List<Task> tasksList = null;
        if (currentUser.getUserType().equals("admin")) {
            tasksList = tasks;
        } else if (currentUser.getUserType().equals("regular")) {
            tasksList = currentUserTasks;
        }

        System.out.println("Select task to update or 0 to exit \n");

        int counter = 0;
        for (Task task : tasksList) {
            counter++;
            System.out.println(counter + ". " + task);
        }
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) return;

        updateableTask = tasksList.get(choice - 1);


        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter task description: ");
        String taskDescription = scanner.nextLine();

        updateableTask.setTaskName(taskName);
        updateableTask.setTaskDesc(taskDescription);

        System.out.println("Task updated ");
    }


    private void chooseUser() {
        System.out.println("Choose User");
        int counter = 0;

        for (User user : users) {
            counter++;
            System.out.println(counter + ". " + user);
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        currentUser = users.get(choice - 1);

        currentUserTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getOwnerID() == currentUser.getUserID()) {
                currentUserTasks.add(task);
            }
        }
        System.out.println("Current user: " + currentUser.getUserName());
    }

    private void createTask() {
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
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
        } else
            for (Task task : tasks) {
                if (currentUser.getUserType() == "admin") {
                    System.out.println(task);
                } else if (task.isHidden() == false) {
                    System.out.println(task);
                }
            }
    }


    private void filterTasksByCriteria() {
        System.out.println("Select filter criteria:");
        System.out.println("1. Filter by Task Name");
        System.out.println("2. Filter by Owner");
        System.out.println("3. Filter by Visibility");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 4) return;

        List<Task> filteredTasks = new ArrayList<>();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter task name to filter: ");
                String taskName = scanner.nextLine();
                filteredTasks = tasks.stream()
                        .filter(task -> task.getTaskName().equalsIgnoreCase(taskName))
                        .toList();
            }
            case 2 -> {
                System.out.print("Enter owner ID to filter: ");
                int ownerId = scanner.nextInt();
                scanner.nextLine();
                filteredTasks = tasks.stream()
                        .filter(task -> task.getOwnerID() == ownerId)
                        .toList();
            }
            case 3 -> {
                System.out.println("Filter by visibility:");
                System.out.println("1. Hidden Tasks");
                System.out.println("2. Visible Tasks");
                int visibilityChoice = scanner.nextInt();
                scanner.nextLine();
                boolean isHidden = (visibilityChoice == 1);
                filteredTasks = tasks.stream()
                        .filter(task -> task.isHidden() == isHidden)
                        .toList();
            }
            default -> System.out.println("Invalid choice!");
        }

        if (filteredTasks.isEmpty()) {
            System.out.println("No tasks found matching the criteria.");
        } else {
            System.out.println("Filtered tasks:");
            for (Task task : filteredTasks) {
                System.out.println(task);
            }
        }
    }
}

