import models.Server;
import utils.Constants;
import utils.Utils;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Application {

    public static void main(String[] args) {
        Server server = new Server(Constants.SERVER_PORT);
        server.start();
    }
}
