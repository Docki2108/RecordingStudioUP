package com.example.demo.repositories;

import com.example.demo.models.Microfon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MicrofonRep extends CrudRepository<Microfon, Long> {
    public List<Microfon> findByName(String name);
    public List<Microfon> findByNameContains(String name);
}
