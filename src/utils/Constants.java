package utils;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Constants {
    public static final int SERVER_PORT = 12345;
    public static final String SERVER = "SERVER";
    public static final String CLIENT = "CLIENT";
    public static final String CLIENT_FORMAT = CLIENT + "-%s";

    // Logger Constants
    public static final String NEW_CLIENT_CONNECTED_FORMAT = "Client id-%s connected to server.";
    public static final String PREVIOUS_TASK_WAS_NOT_COMPLETED = "Your previous task was not completed, yet.";
    public static final String NO_TASK_ASSIGNED_TO_YOU = "No task assigned to you, so you can`t request for repor.";
    public static final String YOUR_NAME_SAVED_TO_SERVER = "Your name saved to server successfully.";
    public static final String WAIT_FOR_CLIENT = "Wait for client to connect...";

    // DataState Constants
    public static final String ASK_FOR_NAME = "Send your name.";
    public static final String TASK = "task";
    public static final String REPORT = "report";
    public static final String ASK_FOR_TASK_OR_REPORT = "Do you want to take a task or deliver your report? (" + TASK + "|" + REPORT + ")";
    public static final String SEND_TASK = "One task sent -> %s";
    public static final String SEND_REPORT = "One report sent -> %s";
    public static final String SEND_NAME = "My name is %s";
    public static final String REQUEST_FOR_TASK = "I want to take a task.";
    public static final String REQUEST_FOR_REPORT = "I want to deliver my report.";
    public static final String WAIT_FOR_REPORT = "I am waiting for your report.";
}
