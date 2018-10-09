package threads;

import models.Client;
import listeners.FindClientListener;
import utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class FindClientThread extends Thread {

    private ServerSocket serverSocket;
    private FindClientListener listener;
    private boolean isActive;

    public FindClientThread(ServerSocket serverSocket, FindClientListener listener) {
        this.serverSocket = serverSocket;
        this.listener = listener;
        this.isActive = true;
    }

    @Override
    public void run() {
        while (isActive) {
            try {
                Socket socket = serverSocket.accept();
                Client client = new Client(socket);
                listener.find(client);
            } catch (IOException e) {
                Logger.o(e);
            }
        }
    }

    public void stopFind(){
        isActive = false;
    }
}
