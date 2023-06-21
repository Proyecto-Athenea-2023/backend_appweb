package com.elmercader.catalogo.repositories;

import com.elmercader.catalogo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCRUDRepository userCRUDRepository;

    /**
     *
     * @return
     */
    public List<User> getAll(){
        return (List<User>) userCRUDRepository.findAll();
    }


    /**
     *
     * @param email
     * @return
     */
    public Optional<User> getByEmail(String email){
        return userCRUDRepository.findByUserEmail(email);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> validateLogin(String email, String password){
        return userCRUDRepository.validateLogin(email, password);
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user){
        return userCRUDRepository.save(user);
    }
}
