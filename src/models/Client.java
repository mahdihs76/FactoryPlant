package models;

import enums.DataState;
import helpers.TDataHelper;
import helpers.TerminalHelper;
import listeners.ClientListener;
import listeners.ReceiveDataListener;
import threads.ReceiveDataThread;
import threads.SendDataThread;
import utils.Constants;
import utils.Logger;
import utils.Utils;

import java.io.*;
import java.net.Socket;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Client implements ReceiveDataListener {
    private long id;
    private String name;
    private Task assignedTask;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private ClientListener listener;

    private Client(long id, ObjectOutputStream out, ObjectInputStream in) {
        this.id = id;
        this.in = in;
        this.out = out;
        this.name = "";
        startThreadToReceiveData();
    }

    public static Client newInstance(Socket socket) throws IOException {
        return new Client(Utils.generateId(),
                new ObjectOutputStream(socket.getOutputStream()),
                new ObjectInputStream(socket.getInputStream()));
    }

    private void startThreadToReceiveData() {
        new ReceiveDataThread(in, this).start();
    }

    public void sendData(TData data) {
        new SendDataThread(data, out).start();
    }

    @Override
    public void receiveData(TData data) {
        Logger.log(data);
        if (listener != null) {
            listener.receiveData(getId(), data);
        }
        switch (data.getType()){
            case ASK_FOR_NAME:
                String name = TerminalHelper.getInstance().inputString();
                sendData(TData.prepareSendName(this, name));
                break;
            case ASK_FOR_TASK_OR_REPORT:
                String tor = TerminalHelper.getInstance().inputString();
                if (tor.equals(Constants.TASK)) {
                    sendData(TData.prepareRequestForTask(this));
                } else {
                    sendData(TData.prepareRequestForReport(this));
                }
                break;
            case SEND_TASK:
                Task task = TDataHelper.toTask(data.getBody());
                setAssignedTask(task);
                break;
            case WAIT_FOR_REPORT:
                sendData(TData.prepareSendReport(this, new Report(assignedTask.getId(), assignedTask.getState())));
                break;
        }
    }

    public long getId() {
        return id;
    }

    public void setListener(ClientListener listener) {
        this.listener = listener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignedTask(Task assignedTask) {
        this.assignedTask = assignedTask;
    }

    public Task getAssignedTask() {
        return assignedTask;
    }

    public void leaveAssignedTask() {
        setAssignedTask(null);
    }
}
