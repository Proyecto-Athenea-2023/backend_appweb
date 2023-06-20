package com.elmercader.catalogo.repositories;

import com.elmercader.catalogo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCRUDRepository extends CrudRepository<User, Integer> {
    public Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE email=? AND password=?", nativeQuery = true)
    public Optional<User> validateLogin(String email, String password);
}
