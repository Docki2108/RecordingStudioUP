package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Raspisaniye {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 20)
    String dennedeli;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 10)
    String vremya_raboti;

    @OneToOne(optional = true, mappedBy = "raspisaniye")
    private Studia studia;


    public Raspisaniye(String dennedeli, String vremya_raboti, Studia studia) {
        this.dennedeli = dennedeli;
        this.vremya_raboti = vremya_raboti;
        this.studia = studia;
    }

    public Raspisaniye() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDennedeli() {
        return dennedeli;
    }

    public void setDennedeli(String dennedeli) {
        this.dennedeli = dennedeli;
    }

    public String getVremya_raboti() {
        return vremya_raboti;
    }

    public void setVremya_raboti(String vremya_raboti) {
        this.vremya_raboti = vremya_raboti;
    }

    public Studia getStudia() {
        return studia;
    }

    public void setStudia(Studia studia) {
        this.studia = studia;
    }
}
