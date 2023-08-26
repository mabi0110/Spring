package com.example.emailapp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class EmailMessage {

    @NotNull
    @Email
    private String sender;

    @NotNull
    @Email
    private String receiver;

    @NotBadWord(lang = {Lang.PL, Lang.EN})
    private String message;

    public EmailMessage(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
