package enums;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public enum TaskType {
    EASY(1000), NORMAL(2000), HARD(5000), EXTREME(10000);

    private int time;

    TaskType(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

}
