package com.geekylikes.app.models.developer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.geekylikes.app.models.geekout.Geekout;
import com.geekylikes.app.models.language.Language;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Developer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private Integer cohort;
//    private String[] languages;
    @OneToMany
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private List<Geekout> geekout;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "developer_language",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    public Set<Language> languages;

    public Developer() {};

    public Developer(String name, String email, Integer cohort, List<Geekout> geekout, Set<Language> languages) {
        this.name = name;
        this.email = email;
        this.cohort = cohort;
        this.geekout = geekout;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCohort() {
        return cohort;
    }

    public void setCohort(Integer cohort) {
        this.cohort = cohort;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }
}
