package com.sergioarboleda.cacharrero.app.services;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author epereira
 */
@Service
public class UserServices {
    @Autowired
    private UserRepository repository;

    /**
     * @return
     */
    public List<User> getAll() {
        return repository.getAll();
    }

    public User save(User user) {
        if (user.getName() != null && user.getEmail() != null && user.getPassword() != null && user.getIdentification() ==null && user.getType()==null ){
            return repository.save(user);
        } else {
            List<User> users = repository.getAll();
            if(users.isEmpty()){
                if(user.getId()==null){
                    return repository.save(user);
                }else{
                    Optional<User> existUser = repository.getUserById(user.getId());
                    if(existUser.isEmpty()){
                        return repository.save(user);
                    }else{
                        return user;
                    }
                }
            }else{
                return user;
            }
        }

    }

    public boolean verifyEmail(String email){
        Optional<User> user = repository.verifyEmail(email);
        if (user.isPresent()){
            return true;
        } else {
            return false;
        }
    }

    public User byEmailPass(String email, String pass){
        Optional<User> user = repository.byEmailPass(email, pass);
        User error =new User();
        if (user.isPresent()){
            return user.get();
        } else {
            return error;
        }

    }

    /**
     *
     * @param user
     * @return
     */
    public User update(User user){
        if (user.getId()!=null){
            Optional<User> userExist = repository.getUserById(user.getId());
            if (userExist.isPresent()){

                if (user.getIdentification()!=null){
                        userExist.get().setIdentification(user.getIdentification());
                }
                if (user.getName()!=null){
                        userExist.get().setName (user.getName());
                }
                if (user.getAddress()!=null){
                    userExist.get().setAddress (user.getAddress());
                }
                if (user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if (user.getZone()!=null){
                    userExist.get().setZone (user.getZone());
                }
                if (user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return repository.save(userExist.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    /**
     *
     * @param idUser
     * @return
     */
    public void deleteById(Integer idUser) {
        Optional<User> user = repository.getUserById(idUser);
        if (user.isPresent()) {
            repository.deleteById(idUser);
        }
    }
}
