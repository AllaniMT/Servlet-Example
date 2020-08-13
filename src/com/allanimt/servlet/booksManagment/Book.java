package com.allanimt.servlet.booksManagment;

public class Book {

    int id;
    String booksName, authorName, topic, state;

    public Book() {}
    public Book(String booksName, String authorName, String topic, String state) {
        this.booksName = booksName;
        this.authorName = authorName;
        this.topic = topic;
        this.state = state;
    }

    public Book(int id, String booksName, String authorName, String topic, String state) {
        this.id = id;
        this.booksName = booksName;
        this.authorName = authorName;
        this.topic = topic;
        this.state = state;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBooksName() {
        return booksName;
    }
    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}