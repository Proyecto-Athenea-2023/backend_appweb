package com.elmercader.catalogo.services;

import com.elmercader.catalogo.models.User;
import com.elmercader.catalogo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @return
     */
    public List<User> getAllUsers(){
        return userRepository.getAll();
    }


    /**
     *
     * @param email
     * @return
     */
    public Boolean getUserByEmail(String email){
        if(Utilities.validateEmail(email)) {
            Optional<User> user = userRepository.getByEmail(email);
            return user.isPresent();
        }
        else
            return null;
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> validateUserLogin(String email, String password){
        if(Utilities.validateEmail(email))
            return userRepository.validateLogin(email, password);
        else
            return null;
    }

    /**
     *
     * @param user
     * @return
     */
    public User insertUser(User user){
        if((user.getUserEmail() != null) && (user.getUserPassword() != null) && (user.getUserName() != null))
            if((Utilities.validateEmail(user.getUserEmail())) && (user.getUserPassword().length() >= 6))
                return userRepository.save(user);
            else
                return null;
        else
            return null;
    }
}
