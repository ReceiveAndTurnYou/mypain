package com.example.mypain.service;

import com.example.mypain.models.Role;
import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Collections;
import java.util.UUID;


@Service
public class usersService implements UserDetailsService {

    @Autowired
    usersRepository userRepository;

    @Autowired
    private MailSenderService mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByusername(username);
    }

    public boolean addUserS(users user)
    {
        users userFromDb = userRepository.findByusername(user.getUsername());

        if(userFromDb!=null)
        {
            return false;
        }


        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        user.setActivationCode(UUID.randomUUID().toString());

        userRepository.save(user);

        if(!StringUtils.isEmpty(user.getEmail()))
        {
            String message = String.format(
                    "Привет, %s! \n" +
                            "Добро пожаловать на Aenpka Company сайт!!!" +
                            "Пожалуйста, перейдите по следующей ссылке: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );


            mailSender.send(user.getEmail(), "Activation Code", message);
        }



        return true;
    }

    public boolean activateUser(String code) {

        users user =  userRepository.findByActivationCode(code);

        if(user==null)
        {
            return false;
        }

        user.setActivationCode(null);
        userRepository.save(user);

        return true;
    }
}
