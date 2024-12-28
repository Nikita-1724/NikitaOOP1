package cs.vsu.nikitaOOP;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
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
