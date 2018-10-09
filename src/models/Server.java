package models;

import listeners.FindClientListener;
import threads.FindClientThread;
import utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Server implements FindClientListener {

    private int port;
    private ServerSocket serverSocket;
    private ArrayList<Client> clients;

    public Server(int port) {
        this.port = port;
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
        startThreadToFindClient();
    }

    private void startThreadToFindClient() {
        new FindClientThread(serverSocket, this).start();
    }


    @Override
    public void find(Client client) {
        clients.add(client);
    }

    private int getPort() {
        return port;
    }

}
