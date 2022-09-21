package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Usluga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 20)
    String name;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 1", min = 1, max = 150)
    String opisanie;

    @Min(message = "Впишите число не меньше 1", value = 1)
    @Max(message = "Число не может быть больше 10", value = 10)
    @NotNull(message = "Укажите стоимость услуги")
    Integer stoimost;

    @ManyToMany
    @JoinTable(name="zayavka_usluga",
            joinColumns=@JoinColumn(name="usluga_id"),
            inverseJoinColumns=@JoinColumn(name="zayavka_id"))
    private List<Zayavka> students;


    public Usluga(String name, String opisanie, Integer stoimost, List<Zayavka> students) {
        this.name = name;
        this.opisanie = opisanie;
        this.stoimost = stoimost;
        this.students = students;
    }

    public Usluga() {
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

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public Integer getStoimost() {
        return stoimost;
    }

    public void setStoimost(Integer stoimost) {
        this.stoimost = stoimost;
    }

    public List<Zayavka> getStudents() {
        return students;
    }

    public void setStudents(List<Zayavka> students) {
        this.students = students;
    }
}
