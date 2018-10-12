package utils;

import enums.DataType;
import helpers.TDataHelper;
import models.TData;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Logger {

    private static final boolean isLoggerEnable = true;

    public static void o(Throwable t) {
        if (isLoggerEnable) {
            System.err.println(Utils.toDateFormat(System.currentTimeMillis()) +
                    " Exception occurred : " +
                    t.getLocalizedMessage());
            t.printStackTrace();
        }
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void log(TData data) {
        DataType type = data.getType();
        String body = data.getBody();
        switch (type) {
            case SEND_REPORT:
                log(String.format(type.getText(), body));
                break;
            case SEND_NAME:
                log(String.format(type.getText(), body));
                break;
            case SEND_TASK:
                log(String.format(type.getText(), body));
                break;
            default:
                log(type.getText());
                break;
        }
    }
}
