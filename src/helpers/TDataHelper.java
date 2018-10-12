package helpers;

import com.google.gson.Gson;
import models.Report;
import models.TData;
import models.Task;

/**
 * Created by mahdihs76 on 10/11/18.
 */
public class TDataHelper {

    public static <T> String toJson(T data){
        return new Gson().toJson(data);
    }

    public static TData toData(String json) {
        return new Gson().fromJson(json, TData.class);
    }

    public static Task toTask(String json) {
        return new Gson().fromJson(json, Task.class);
    }

    public static Report toReport(String json) {
        return new Gson().fromJson(json, Report.class);
    }
}
