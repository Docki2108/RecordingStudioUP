package com.example.demo.repositories;

import com.example.demo.models.Microfon;
import com.example.demo.models.Monitori;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonitoriRep extends CrudRepository<Monitori, Long> {
    public List<Monitori> findByName(String name);
    public List<Monitori> findByNameContains(String name);
}
