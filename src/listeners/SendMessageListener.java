package listeners;

import enums.SendMessageState;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public interface SendMessageListener {
    void finish(SendMessageState state);
}
