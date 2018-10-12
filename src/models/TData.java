package models;

import enums.DataState;
import enums.DataType;
import utils.Constants;
import utils.Utils;

import java.io.Serializable;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class TData implements Serializable {
    private long id;
    private String from;
    private String to;
    private DataType type;
    private DataState state = DataState.SENDING;
    private String body;

    private TData(Client to) {
        this.id = Utils.generateId();
        this.from = Constants.SERVER;
        this.to = String.format(Constants.CLIENT_FORMAT, to.getId());
    }

    private TData(DataType type, Client to) {
        this(to);
        this.type = type;
    }

    private TData(DataType type, String body, Client to) {
        this(type, to);
        this.body = body;
    }

    private TData(Client from, DataType type) {
        this.id = Utils.generateId();
        this.from = String.format(Constants.CLIENT_FORMAT, from.getId());
        this.to = Constants.SERVER;
        this.type = type;
    }
    private TData(Client from, DataType type, String body) {
        this(from, type);
        this.body = body;
    }

    public static TData prepareAskName(Client to) {
        return new TData(DataType.ASK_FOR_NAME, to);
    }

    public static TData prepareSendName(Client from, String name) {
        return new TData(from, DataType.SEND_NAME, name);
    }

    public static TData prepareAskForTOR(Client to) {
        return new TData(DataType.ASK_FOR_TASK_OR_REPORT, to);
    }

    public static TData prepareWaitForReport(Client to) {
        return new TData(DataType.WAIT_FOR_REPORT, to);
    }

    public static TData prepareRequestForTask(Client from) {
        return new TData(from, DataType.REQUEST_FOR_TASK);
    }

    public static TData prepareRequestForReport(Client from) {
        return new TData(from, DataType.REQUEST_FOR_REPORT);
    }

    public static TData prepareSendTask(Client to, Task task) {
        return new TData(DataType.SEND_TASK, task.toString(), to);
    }

    public static TData prepareSendReport(Client from, Report report) {
        return new TData(from, DataType.SEND_REPORT, report.toString());
    }

    public long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public DataType getType() {
        return type;
    }

    public DataState getState() {
        return state;
    }

    public void setState(DataState state) {
        this.state = state;
    }

    public String getBody() {
        return body;
    }
}