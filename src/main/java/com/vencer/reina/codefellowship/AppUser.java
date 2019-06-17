package com.vencer.reina.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
public class AppUser {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String username;
    String password;

    public AppUser(){}

    public AppUser(String username,String password){

        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
