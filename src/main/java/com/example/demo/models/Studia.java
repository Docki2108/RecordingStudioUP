package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Studia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 100)
    String adres;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="raspisaniye_id")
    private Raspisaniye raspisaniye;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="naborApparaturi_id")
    private NaborApparaturi naborApparaturi;

    @OneToOne(optional = true, mappedBy = "studia")
    private Seans seans;

    public Studia(String adres, Raspisaniye raspisaniye, NaborApparaturi naborApparaturi, Seans seans) {
        this.adres = adres;
        this.raspisaniye = raspisaniye;
        this.naborApparaturi = naborApparaturi;
        this.seans = seans;
    }

    public Studia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Raspisaniye getRaspisaniye() {
        return raspisaniye;
    }

    public void setRaspisaniye(Raspisaniye raspisaniye) {
        this.raspisaniye = raspisaniye;
    }

    public NaborApparaturi getNaborApparaturi() {
        return naborApparaturi;
    }

    public void setNaborApparaturi(NaborApparaturi naborApparaturi) {
        this.naborApparaturi = naborApparaturi;
    }

    public Seans getSeans() {
        return seans;
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
    }
}
