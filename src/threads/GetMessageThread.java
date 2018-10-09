package threads;

import utils.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class GetMessageThread extends Thread {

    private ObjectInputStream inputStream;

    public GetMessageThread(ObjectInputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object object = inputStream.readObject();
            } catch (Exception e) {
                Logger.o(e);
            }
        }
    }
}
