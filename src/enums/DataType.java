package enums;

import utils.Constants;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public enum DataType {
    ASK_FOR_NAME(Constants.ASK_FOR_NAME),
    ASK_FOR_TASK_OR_REPORT(Constants.ASK_FOR_TASK_OR_REPORT),
    SEND_TASK(Constants.SEND_TASK),
    SEND_REPORT(Constants.SEND_REPORT),
    SEND_NAME(Constants.SEND_NAME),
    REQUEST_FOR_TASK(Constants.REQUEST_FOR_TASK),
    REQUEST_FOR_REPORT(Constants.REQUEST_FOR_REPORT),
    WAIT_FOR_REPORT(Constants.WAIT_FOR_REPORT);

    private final String text;

    DataType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
