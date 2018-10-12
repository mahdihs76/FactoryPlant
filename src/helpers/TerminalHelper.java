package helpers;

import java.util.Scanner;

/**
 * Created by mahdihs76 on 10/12/18.
 */
public class TerminalHelper {
    private static TerminalHelper instance = new TerminalHelper();

    private TerminalHelper(){}

    public static TerminalHelper getInstance() {
        return instance;
    }

    public String inputString(){
        return new Scanner(System.in).nextLine();
    }
}
