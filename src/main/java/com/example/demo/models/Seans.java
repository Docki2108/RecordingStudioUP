package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Seans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 15)
    String dataivremya;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="studia_id")
    private Studia studia;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="zayavka_id")
    private Zayavka zayavka;

    public Seans(String dataivremya, Studia studia, Zayavka zayavka) {
        this.dataivremya = dataivremya;
        this.studia = studia;
        this.zayavka = zayavka;
    }

    public Seans() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataivremya() {
        return dataivremya;
    }

    public void setDataivremya(String dataivremya) {
        this.dataivremya = dataivremya;
    }

    public Studia getStudia() {
        return studia;
    }

    public void setStudia(Studia studia) {
        this.studia = studia;
    }

    public Zayavka getZayavka() {
        return zayavka;
    }

    public void setZayavka(Zayavka zayavka) {
        this.zayavka = zayavka;
    }
}
