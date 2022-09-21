package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String login, password;
    private boolean active;

    @ElementCollection(targetClass = Rol.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "rol", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Rol> roli;

    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Zayavka> zayavki;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 50)
    String nick;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 50)
    String familiya;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 50)
    String imya;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 11, max = 11)
    String telephone;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 50)
    String mail;

    public User(String login, String password, Set<Rol> roli, Collection<Zayavka> zayavki, String nick, String familiya, String imya, String telephone, String mail, boolean active) {
        this.login = login;
        this.password = password;
        this.roli = roli;
        this.zayavki = zayavki;
        this.nick = nick;
        this.familiya = familiya;
        this.imya = imya;
        this.telephone = telephone;
        this.mail = mail;
        this.active = active;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoli() {
        return roli;
    }

    public void setRoli(Set<Rol> roli) {
        this.roli = roli;
    }

    public Collection<Zayavka> getZayavki() {
        return zayavki;
    }

    public void setZayavki(Collection<Zayavka> zayavki) {
        this.zayavki = zayavki;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
