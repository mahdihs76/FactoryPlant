package models;

import java.io.Serializable;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Message implements Serializable {
    private int id;
    private String from;
    private String to;
    private String text;

    public Message(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }
}
