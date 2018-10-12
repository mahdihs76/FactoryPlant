package threads;

import helpers.TDataHelper;
import listeners.ReceiveDataListener;
import utils.Logger;

import java.io.ObjectInputStream;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class ReceiveDataThread extends Thread {

    private ObjectInputStream inputStream;
    private ReceiveDataListener listener;
    private boolean isActive;

    public ReceiveDataThread(ObjectInputStream inputStream,
                             ReceiveDataListener listener) {
        this.inputStream = inputStream;
        this.listener = listener;
        this.isActive = true;
    }

    @Override
    public void run() {
        while (isActive) {
            try {
                String data = (String) inputStream.readObject();
                listener.receiveData(TDataHelper.toData(data));
            } catch (Exception e) {
                Logger.o(e);
            }
        }
    }

    public void stopReceive(){
        isActive = false;
    }
}
