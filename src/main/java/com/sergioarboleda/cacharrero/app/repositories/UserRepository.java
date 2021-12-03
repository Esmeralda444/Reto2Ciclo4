/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.cacharrero.app.repositories;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author work
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository repository;

    /**
     * @return
     */

    public List<User> getAll() {
        return (List<User>) repository.findAll();

    }

    /**
     * @param user
     * @return
     */
    public User save(User user) {
        return repository.save(user);
    }

    public Optional<User> verifyEmail(String email){
        return repository.findByEmail(email);

    }

    public Optional<User> byEmailPass(String email, String pass){
        return repository.findByEmailAndPassword(email, pass);
    }

    public Optional<User> getUserById(Integer idUser) {
        return repository.findById(idUser);
    }

    /**
     *
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

}
