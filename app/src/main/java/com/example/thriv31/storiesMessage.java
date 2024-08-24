package com.example.thriv31;

public class storiesMessage {
    private String userName;
    private String content;

    public storiesMessage(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }

    public String getUserName() { return userName; }
    public String getContent() { return content; }
}
