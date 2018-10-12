package models;

import enums.DataState;
import enums.TaskType;
import helpers.TDataHelper;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Task {
    private int id;
    private String data;
    private TaskType type;
    private DataState state;

    public Task(int id, String data, TaskType type) {
        this.id = id;
        this.data = data;
        this.type = type;
        this.state = DataState.SENDING;
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

    public DataState getState() {
        return state;
    }

    public void setState(DataState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return TDataHelper.toJson(this);
    }
}
