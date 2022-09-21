package com.example.demo.repositories;

import com.example.demo.models.MiksherniyPult;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MiksherniyPultRep extends CrudRepository<MiksherniyPult, Long> {
    public List<MiksherniyPult> findByName(String name);
    public List<MiksherniyPult> findByNameContains(String name);
}
