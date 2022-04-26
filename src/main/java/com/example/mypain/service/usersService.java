package com.example.mypain.service;

import com.example.mypain.models.Role;
import com.example.mypain.models.users;
import com.example.mypain.repositories.RoleRepository;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
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
public class usersService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;


    @Autowired
    usersRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        users user = userRepository.findByLogin(username);

        if(user==null)
        {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public users findUserById(Long id)
    {
        Optional<users> userFromDb = userRepository.findById(id);
        return userFromDb.orElse(new users());
    }

    public List<users> allUsers()
    {
        return userRepository.findAll();
    }

    public boolean saveUser(users user)
    {
        users userFromDb = userRepository.findByLogin(user.getLogin());

        if(userFromDb!=null)
        {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return true;
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
