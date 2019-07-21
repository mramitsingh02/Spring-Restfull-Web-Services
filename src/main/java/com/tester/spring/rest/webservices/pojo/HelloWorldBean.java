package com.tester.spring.rest.webservices.pojo;

public class HelloWorldBean {
private int messagesId;
private String messages;

    public HelloWorldBean(int messagesId, String messages) {
        this.messagesId = messagesId;
        this.messages = messages;
    }

    public HelloWorldBean(String messages) {
        this.messages= messages;

    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(int messagesId) {
        this.messagesId = messagesId;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "messagesId=" + messagesId +
                ", messages='" + messages + '\'' +
                '}';
    }
}
