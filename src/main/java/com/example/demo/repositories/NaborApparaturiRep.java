package com.example.demo.repositories;

import com.example.demo.models.NaborApparaturi;
import com.example.demo.models.Studia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NaborApparaturiRep extends CrudRepository<NaborApparaturi, Long> {
    public List<NaborApparaturi> findById(String id);
    public List<NaborApparaturi> findByIdContains(String id);
}
