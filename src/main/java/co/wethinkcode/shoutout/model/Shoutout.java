package co.wethinkcode.shoutout.model;

import java.io.Serializable;

public class Shoutout implements Serializable {

    private String sender;
    private String recipient;
    private String message;

    public Shoutout() {}

    public Shoutout(String sender, String recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    public String getSender() { 
        return sender; 
        }

    public void setSender(String sender) { 
        this.sender = sender; 
        }

    public String getRecipient() { 
        return recipient; 
        }

    public void setRecipient(String recipient) {
        this.recipient = recipient; 
        }

    public String getMessage() { 
        return message; 
        }

    public void setMessage(String message) {    this.message = message; 
    }
}