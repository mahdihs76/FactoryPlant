package utils;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Logger {

    private static final boolean isLoggerEnable = true;

    public static void o(Throwable t) {
        if (isLoggerEnable) {
            System.err.println(Utils.toDateFormat(System.currentTimeMillis()) +
                    " Exception occurred : " +
                    t.getMessage());
            t.printStackTrace();
        }
    }
}
