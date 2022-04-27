package com.example.mypain.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long users_id;

    private String user_name, surname, login, password, country, email;


    public users() {
    }

    public users(long users_id, String user_name, String surname, String login, String password, String country, String email) {
        this.users_id = users_id;
        this.user_name = user_name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.country = country;
        this.email = email;
    }

    public users(String user_name, String surname, String login, String password, String country, String email) {
        this.user_name = user_name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.country = country;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

