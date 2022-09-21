package com.example.demo.models;

import javax.persistence.*;

@Entity
public class NaborApparaturi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="naushniki_id")
    private Naushniki naushniki;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="monitor_id")
    private Monitori monitori;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="microfon_id")
    private Microfon microfon;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="po_id")
    private PO po;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name="miksherniypult_id")
    private MiksherniyPult miksherniyPult;

    @OneToOne(optional = true, mappedBy = "naborApparaturi")
    private Studia studia;

    public NaborApparaturi(Naushniki naushniki, Monitori monitori, Microfon microfon, PO po, MiksherniyPult miksherniyPult, Studia studia) {
        this.naushniki = naushniki;
        this.monitori = monitori;
        this.microfon = microfon;
        this.po = po;
        this.miksherniyPult = miksherniyPult;
        this.studia = studia;
    }

    public NaborApparaturi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Naushniki getNaushniki() {
        return naushniki;
    }

    public void setNaushniki(Naushniki naushniki) {
        this.naushniki = naushniki;
    }

    public Monitori getMonitori() {
        return monitori;
    }

    public void setMonitori(Monitori monitori) {
        this.monitori = monitori;
    }

    public Microfon getMicrofon() {
        return microfon;
    }

    public void setMicrofon(Microfon microfon) {
        this.microfon = microfon;
    }

    public PO getPo() {
        return po;
    }

    public void setPo(PO po) {
        this.po = po;
    }

    public MiksherniyPult getMiksherniyPult() {
        return miksherniyPult;
    }

    public void setMiksherniyPult(MiksherniyPult miksherniyPult) {
        this.miksherniyPult = miksherniyPult;
    }

    public Studia getStudia() {
        return studia;
    }

    public void setStudia(Studia studia) {
        this.studia = studia;
    }
}
