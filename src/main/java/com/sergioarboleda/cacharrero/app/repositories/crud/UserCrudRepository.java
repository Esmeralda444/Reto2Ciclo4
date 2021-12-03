/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.cacharrero.app.repositories.crud;

import com.sergioarboleda.cacharrero.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author work
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    /**
     * @param name
     * @return
     */

    public Optional<User> findByName(String name);

    /**
     * @param email
     * @return
     */

    public Optional<User> findByEmail(String email);

    /**
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
}
