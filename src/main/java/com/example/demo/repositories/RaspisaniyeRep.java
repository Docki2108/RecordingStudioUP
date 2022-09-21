package com.example.demo.repositories;

import com.example.demo.models.Raspisaniye;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RaspisaniyeRep extends CrudRepository<Raspisaniye, Long> {
    public List<Raspisaniye> findByDennedeli(String dennedeli);
    public List<Raspisaniye> findByDennedeliContains(String dennedeli);
}
