package com.example.demo.repositories;

import com.example.demo.models.Seans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeansRep extends CrudRepository<Seans, Long> {
    public List<Seans> findByDataivremya(String dataivremya);
    public List<Seans> findByDataivremyaContains(String dataivremya);
}
