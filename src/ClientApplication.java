import models.Client;
import utils.Constants;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by mahdihs76 on 10/12/18.
 */
public class ClientApplication {
    public static void main(String[] args) {
        try {
            Client client = Client.newInstance(new Socket("localhost", Constants.SERVER_PORT));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
