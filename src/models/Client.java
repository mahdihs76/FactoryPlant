package models;

import listeners.SendMessageListener;
import threads.SendMessageThread;

import java.io.*;
import java.net.Socket;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Client {
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public Client(Socket socket) throws IOException {
        Socket socket1 = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        startThreadToGetData();
    }

    private void startThreadToGetData() {

    }

    public void sendMessage(Message message,
                            SendMessageListener listener) {
        new SendMessageThread(message, listener, out).start();
    }
}
