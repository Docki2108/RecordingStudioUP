package com.example.demo.repositories;

import com.example.demo.models.Seans;
import com.example.demo.models.Studia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudiaRep extends CrudRepository<Studia, Long> {
    public List<Studia> findByAdres(String adres);
    public List<Studia> findByAdresContains(String adres);
}
