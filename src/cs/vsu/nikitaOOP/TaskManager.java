package cs.vsu.nikitaOOP;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String name, LocalDateTime time) {
        if (name == null || name.isBlank()) {
            System.out.println("Task name cannot be empty.");
            return;
        }
        tasks.add(new Task(name.trim(), time));
        System.out.println("Task added successfully.");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void removeTask(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
