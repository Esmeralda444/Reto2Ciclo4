package com.sergioarboleda.cacharrero.app.repositories;

import com.sergioarboleda.cacharrero.app.repositories.crud.CloneCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CloneRepository {
    @Autowired
    private CloneCrudRepository repository;
}
