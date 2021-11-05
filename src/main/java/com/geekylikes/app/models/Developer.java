package com.geekylikes.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Developer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private Integer cohort;
    private String[] languages;

    public Developer() {};

    public Developer(String name, String email, Integer cohort, String[] languages) {
        this.name = name;
        this.email = email;
        this.cohort = cohort;
        this.languages = languages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCohort() {
        return cohort;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCohort(Integer cohort) {
        this.cohort = cohort;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
