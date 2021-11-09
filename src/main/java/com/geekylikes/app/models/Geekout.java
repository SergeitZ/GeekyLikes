package com.geekylikes.app.models;

import javax.persistence.*;

@Entity
public class Geekout {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;

    private String title;
    private String content;

    public Geekout() {}

    public Geekout(Developer developer, String title, String content) {
        this.developer = developer;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
