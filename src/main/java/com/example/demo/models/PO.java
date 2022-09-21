package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class PO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 100)
    String name;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 10)
    String versiya;

    @OneToOne(optional = true, mappedBy = "po")
    private NaborApparaturi naborApparaturi;

    public PO(String name, String versiya, NaborApparaturi naborApparaturi) {
        this.name = name;
        this.versiya = versiya;
        this.naborApparaturi = naborApparaturi;
    }

    public PO() {
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

    public String getVersiya() {
        return versiya;
    }

    public void setVersiya(String versiya) {
        this.versiya = versiya;
    }

    public NaborApparaturi getNaborApparaturi() {
        return naborApparaturi;
    }

    public void setNaborApparaturi(NaborApparaturi naborApparaturi) {
        this.naborApparaturi = naborApparaturi;
    }
}
