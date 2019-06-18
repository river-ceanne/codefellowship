package com.vencer.reina.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class AppUser implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String username;
    String password;
    Date dob;
    String firstname;
    String lastname;
    String bio;


    public AppUser(){}

    public AppUser(String username,String password, Date dob, String firstname, String lastname, String bio){
        this.password = password;
        this.username = username;
        this.dob = dob;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
    }

    public AppUser(String username, String password){
        this.password = password;
        this.username = username;
    }


    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getDob() {
        return dob;
    }

    public String getBio() {
        return bio;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
