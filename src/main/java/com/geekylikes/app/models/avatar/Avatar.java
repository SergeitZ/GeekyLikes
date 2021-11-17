package com.geekylikes.app.models.avatar;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geekylikes.app.models.developer.Developer;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;

    @OneToOne
    private Developer developer;

    public Avatar() {
    }

    public Avatar(String url, Developer developer) {
        this.url = url;
        this.developer = developer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
