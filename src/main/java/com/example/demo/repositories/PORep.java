package com.example.demo.repositories;

import com.example.demo.models.Naushniki;
import com.example.demo.models.PO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PORep extends CrudRepository<PO, Long> {
    public List<PO> findByName(String name);
    public List<PO> findByNameContains(String name);
}
