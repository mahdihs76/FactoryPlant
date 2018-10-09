package models;

import enums.TaskType;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Task {
    private int id;
    private String data;
    private TaskType type;

    public Task(int id, String data, TaskType type) {
        this.id = id;
        this.data = data;
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public TaskType getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
