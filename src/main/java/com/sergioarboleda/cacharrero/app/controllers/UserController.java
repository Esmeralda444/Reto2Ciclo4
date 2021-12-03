package com.sergioarboleda.cacharrero.app.controllers;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author esmeralda
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user")
public class UserController {

    /**
     * atributo servicio
     */
    @Autowired
    private UserServices service;

    /**
     * metodo para obetner todos los usuarios
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> getUsers() {
        return service.getAll();
    }

    /**
     * metodo para crear un usuario
     *
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);

    }

    /**
     * metodo para verificar si existe un email
     *
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return service.verifyEmail(email);

    }

    /**
     * metodo para validad usuario
     *
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("/{email}/{pass}")
    public User existUser(@PathVariable("email") String email, @PathVariable("pass") String pass) {
        return service.byEmailPass(email, pass);
    }

    /**
     * metodo para actualizar
     *
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    /**
     *
     * @param idUser
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer idUser) {
        service.deleteById(idUser);
    }
}