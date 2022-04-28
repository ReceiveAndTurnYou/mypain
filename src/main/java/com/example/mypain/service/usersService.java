/*
package com.example.mypain.service;

import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class usersService {

    @PersistenceContext
    private EntityManager em;


    @Autowired
    usersRepository userRepository;

    public users findUserById(Long id)
    {
        Optional<users> userFromDb = userRepository.findById(id);
        return userFromDb.orElse(new users());
    }

    public List<users> allUsers()
    {
        return userRepository.findAll();
    }


    public boolean deleteUser(Long id)
    {
        if(userRepository.findById(id).isPresent())
        {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<users> usergtList(Long idMin)
    {
        return em.createQuery("SELECT u FROM users u WHERE u.users_id > :paramId", users.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
*/
