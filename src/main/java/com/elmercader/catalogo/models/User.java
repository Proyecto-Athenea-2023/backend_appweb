package com.elmercader.catalogo.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User  implements Serializable {

    // Attributes - Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 80, nullable = false)
    private String userName;
    @Column(length = 50, nullable = false, unique = true)
    private String userEmail;
    @Column(length = 50, nullable = false)
    private String userPassword;


    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     *
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     *
     * @return
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
