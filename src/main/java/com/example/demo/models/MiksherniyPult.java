package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class MiksherniyPult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 100)
    String name;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 10)
    String tip;

    @OneToOne(optional = true, mappedBy = "miksherniyPult")
    private NaborApparaturi naborApparaturi;

    public MiksherniyPult(String name, String tip, NaborApparaturi naborApparaturi) {
        this.name = name;
        this.tip = tip;
        this.naborApparaturi = naborApparaturi;
    }

    public MiksherniyPult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public NaborApparaturi getNaborApparaturi() {
        return naborApparaturi;
    }

    public void setNaborApparaturi(NaborApparaturi naborApparaturi) {
        this.naborApparaturi = naborApparaturi;
    }
}
