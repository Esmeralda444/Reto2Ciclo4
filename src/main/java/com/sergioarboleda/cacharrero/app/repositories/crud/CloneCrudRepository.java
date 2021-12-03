package com.sergioarboleda.cacharrero.app.repositories.crud;

import com.sergioarboleda.cacharrero.app.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CloneCrudRepository extends MongoRepository<Clone, Integer> {
}
