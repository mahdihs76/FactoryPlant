package models;

import enums.TaskType;

import java.util.ArrayList;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class TaskManager {
    private static TaskManager instance = new TaskManager();
    private ArrayList<Task> tasks;

    private TaskManager(){}

    public static TaskManager newInstance() {
        return instance;
    }

    public void init() {
        tasks.add(new Task(1,"Change decoration of the office", TaskType.EASY));
        tasks.add(new Task(2,"Improve main server RAM to 128Gb", TaskType.HARD));
        tasks.add(new Task(3,"Transfer electronic trashes ", TaskType.NORMAL));
        tasks.add(new Task(4,"Develop android application for the office", TaskType.HARD));
        tasks.add(new Task(5,"Negotiate with government to fund our application", TaskType.EXTREME));
        tasks.add(new Task(6,"Strengthening human infrastructure", TaskType.EXTREME));
        tasks.add(new Task(7,"Prepare proposal for previous RFP", TaskType.NORMAL));
        tasks.add(new Task(8,"Mail the whole handy letters", TaskType.EASY));
        tasks.add(new Task(9,"Plan for weekend trip", TaskType.EASY));
        tasks.add(new Task(10,"Kill the boss", TaskType.EXTREME));
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }
}
