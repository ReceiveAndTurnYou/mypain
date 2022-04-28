package com.example.mypain.models;


import javax.persistence.*;
import java.util.Set;

@Entity
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long users_id;

    private String username, surname, login, password, country, email;

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public users() {
    }

    public users(long users_id, String username, String surname, String login, String password, String country, String email) {
        this.users_id = users_id;
        this.username = username;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.country = country;
        this.email = email;
    }

    public users(String username, String surname, String login, String password, String country, String email) {
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

