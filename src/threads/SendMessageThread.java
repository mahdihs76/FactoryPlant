package threads;

import enums.SendMessageState;
import models.Message;
import listeners.SendMessageListener;
import utils.Logger;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class SendMessageThread extends Thread{

    private Message message;
    private SendMessageListener listener;
    private ObjectOutputStream outputStream;

    public SendMessageThread(Message message,
                             SendMessageListener listener,
                             ObjectOutputStream outputStream) {
        this.message = message;
        this.listener = listener;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            outputStream.writeObject(message);
            listener.finish(SendMessageState.SUCCESSFUL);
        } catch (IOException e) {
            Logger.o(e);
            listener.finish(SendMessageState.FAILED);
        }
    }
}
