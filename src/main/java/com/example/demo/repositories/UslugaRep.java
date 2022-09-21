package com.example.demo.repositories;

import com.example.demo.models.Studia;
import com.example.demo.models.Usluga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UslugaRep extends CrudRepository<Usluga, Long> {
    public List<Usluga> findByName(String name);
    public List<Usluga> findByNameContains(String name);
}
