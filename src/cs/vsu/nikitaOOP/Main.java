package cs.vsu.nikitaOOP;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static class Task {
        private final String name;
        private final LocalDateTime time;

        public Task(String name, LocalDateTime time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return "Task: " + name + ", Time: " + time.format(formatter);
        }
    }

    public static class TaskManager {
        private final List<Task> tasks;

        public TaskManager() {
            tasks = new ArrayList<>();
        }

        public void addTask(String name, LocalDateTime time) {
            if (name == null || name.isBlank()) {
                System.out.println("Имя задачи не может быть пустым.");
                return;
            }
            tasks.add(new Task(name.trim(), time)); // Task доступен, т.к. он публичный
            System.out.println("Задача успешно добавлена.");
        }

        public void listTasks() {
            if (tasks.isEmpty()) {
                System.out.println("Нет доступных задач.");
            } else {
                System.out.println("Задачи:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            }
        }

        public void removeTask(int index) {
            if (index > 0 && index <= tasks.size()) {
                tasks.remove(index - 1);
                System.out.println("Задача успешно удалена.");
            } else {
                System.out.println("Неверный номер задачи.");
            }
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nTask Manager");
                System.out.println("1. Добавить задачу");
                System.out.println("2. Список задач");
                System.out.println("3. Удалить задачу");
                System.out.println("4. Выход");
                System.out.print("Выберите нужный вариант: ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Неверный ввод. Пожалуйста, введите число.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Введите название задачи: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Введите время выполнения задачи (yyyy-MM-dd HH:mm): ");
                        String timeInput = scanner.nextLine().trim();
                        try {
                            LocalDateTime time = LocalDateTime.parse(timeInput, formatter);
                            taskManager.addTask(name, time);
                        } catch (Exception e) {
                            System.out.println("Неверный формат даты и времени. Пожалуйста, используйте yyyy-MM-dd HH:mm.");
                        }
                        break;
                    case 2:
                        taskManager.listTasks();
                        break;
                    case 3:
                        System.out.print("Введите номер задачи для удаления: ");
                        try {
                            int index = Integer.parseInt(scanner.nextLine().trim());
                            taskManager.removeTask(index);
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный номер задания. Пожалуйста, введите правильный номер.");
                        }
                        break;
                    case 4:
                        System.out.println("Выход из TaskManager. До свидания!");
                        return;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                }
            }
        }
    }
}
