import models.Server;
import models.TaskManager;
import utils.Constants;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class ServerApplication {

    public static void main(String[] args) {
        TaskManager.getInstance().init();

        Server server = new Server(Constants.SERVER_PORT);
        server.start();
    }
}
