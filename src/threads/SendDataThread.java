package threads;

import enums.DataState;
import helpers.TDataHelper;
import models.TData;
import utils.Logger;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class SendDataThread extends Thread{

    private TData data;
    private ObjectOutputStream outputStream;

    public SendDataThread(TData data,
                          ObjectOutputStream outputStream) {
        this.data = data;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            outputStream.writeObject(TDataHelper.toJson(data));
            Logger.log(data);
        } catch (IOException e) {
            Logger.o(e);
        }
    }
}
