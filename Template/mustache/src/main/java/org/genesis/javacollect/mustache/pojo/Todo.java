package org.genesis.javacollect.mustache.pojo;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: Todo
 * @Package org.genesis.javacollect.mustache.pojo
 * @Description: to do
 * @date 2018/8/6 15:25
 */
public class Todo {
    private String title;
    private String text;
    private boolean done;
    private String createdOn;
    private Date completedOn;

    // constructors, getters and setters
    public Todo(String title, String text) {
        this(title, text, "");
    }

    public Todo(String title, String text, String createdOn) {
        this.title = title;
        this.text = text;
        this.createdOn = createdOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Date getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(Date completedOn) {
        this.completedOn = completedOn;
    }
}
