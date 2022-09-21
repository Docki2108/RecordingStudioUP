package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Microfon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 100)
    String name;

    @Min(message = "Впишите число не меньше 0", value = 0)
    @Max(message = "Число не может быть больше 100", value = 100)
    @NotNull(message = "Укажите количество! ")
    Integer kolichestvo;

    @OneToOne(optional = true, mappedBy = "microfon")
    private NaborApparaturi naborApparaturi;

    public Microfon(String name, Integer kolichestvo, NaborApparaturi naborApparaturi) {
        this.name = name;
        this.kolichestvo = kolichestvo;
        this.naborApparaturi = naborApparaturi;
    }

    public Microfon() {
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

    public Integer getKolichestvo() {
        return kolichestvo;
    }

    public void setKolichestvo(Integer kolichestvo) {
        this.kolichestvo = kolichestvo;
    }

    public NaborApparaturi getNaborApparaturi() {
        return naborApparaturi;
    }

    public void setNaborApparaturi(NaborApparaturi naborApparaturi) {
        this.naborApparaturi = naborApparaturi;
    }
}
