package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Zayavka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private User user;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 100)
    String name;

    @ManyToMany
    @JoinTable (name="zayavka_usluga",
            joinColumns=@JoinColumn (name="zayavka_id"),
            inverseJoinColumns=@JoinColumn(name="usluga_id"))
    private List<Usluga> uslugi;

    @OneToOne(optional = true, mappedBy = "zayavka")
    private Seans seans;

    public Zayavka(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public Zayavka() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
