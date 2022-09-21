package com.example.demo.repositories;

import com.example.demo.models.Zayavka;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZayavkaRep extends CrudRepository<Zayavka, Long> {
    public List<Zayavka> findByName(String name);
    public List<Zayavka> findByNameContains(String name);
}
