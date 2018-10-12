package models;

import enums.DataState;
import helpers.TDataHelper;
import listeners.ClientListener;
import listeners.FindClientListener;
import sun.rmi.runtime.Log;
import threads.FindClientThread;
import utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

import static utils.Constants.*;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Server implements FindClientListener, ClientListener {

    private int port;
    private ServerSocket serverSocket;
    private Map<Long, Client> clients;

    public Server(int port) {
        this.port = port;
        clients = new HashMap<>();
    }

    private void setup() {
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            Logger.o(e);
        }
    }

    public void start() {
        setup();
        startThreadToFindClients();
    }

    private void startThreadToFindClients() {
        new FindClientThread(serverSocket, this).start();
    }


    @Override
    public void find(Client client) {
        long id = client.getId();
        clients.put(id, client);
        client.setListener(this);
        Logger.log(String.format(NEW_CLIENT_CONNECTED_FORMAT, id));
        sendData(id, TData.prepareAskName(client));
    }

    private int getPort() {
        return port;
    }

    public void sendData(long clientId, TData data) {
        getClient(clientId).sendData(data);
    }

    @Override
    public void receiveData(long clientId, TData data) {
        Logger.log(data);
        Client client = getClient(clientId);
        Task assignedTask = client.getAssignedTask();
        switch (data.getType()) {
            case SEND_NAME:
                client.setName(data.getBody());
                Logger.log(YOUR_NAME_SAVED_TO_SERVER);
                client.sendData(TData.prepareAskForTOR(client));
                break;
            case REQUEST_FOR_TASK:
                if (assignedTask == null){
                    Task task = TaskManager.getInstance().getLastTask();
                    client.setAssignedTask(task);
                    client.sendData(TData.prepareSendTask(client, task));
                } else {
                    Logger.log(PREVIOUS_TASK_WAS_NOT_COMPLETED);
                }
                client.sendData(TData.prepareAskForTOR(client));
                break;
            case REQUEST_FOR_REPORT:
                if (assignedTask == null){
                    Logger.log(NO_TASK_ASSIGNED_TO_YOU);
                } else {
                    client.sendData(TData.prepareWaitForReport(client));
                }
                break;
            default:
            case SEND_REPORT:
                Report report = TDataHelper.toReport(data.getBody());
                if (report.getState() == DataState.SUCCESSFUL){
                    client.leaveAssignedTask();
                } else if (report.getState() == DataState.FAILED){
                    TaskManager.getInstance().addTask(assignedTask);
                    client.leaveAssignedTask();
                }
                break;
        }
    }

    public Client getClient(long clientId){
        return clients.get(clientId);
    }
}
