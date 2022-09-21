package com.example.demo.repositories;

import com.example.demo.models.Microfon;
import com.example.demo.models.Naushniki;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NaushnikiRep extends CrudRepository<Naushniki, Long> {
    public List<Naushniki> findByName(String name);
    public List<Naushniki> findByNameContains(String name);
}
