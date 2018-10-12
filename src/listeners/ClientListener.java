package listeners;

import enums.DataState;
import models.TData;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public interface ClientListener {
    void receiveData(long clientId, TData data);
}
