package models;

import enums.DataState;
import helpers.TDataHelper;

/**
 * Created by mahdihs76 on 10/12/18.
 */
public class Report {
    private int taskId;
    private DataState state;

    public Report(int taskId, DataState state) {
        this.taskId = taskId;
        this.state = state;
    }

    public int getTaskId() {
        return taskId;
    }

    public DataState getState() {
        return state;
    }

    @Override
    public String toString() {
        return TDataHelper.toJson(this);
    }
}
