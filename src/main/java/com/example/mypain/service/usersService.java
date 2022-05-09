package com.example.mypain.service;

import com.example.mypain.models.Role;
import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class usersService implements UserDetailsService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    usersRepository userRepository;

    @Autowired
    private MailSenderService mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByusername(username);
    }

    public boolean addUserS(users user, @RequestParam("file")MultipartFile file) throws IOException
    {
        users userFromDb = userRepository.findByusername(user.getUsername());

        if(userFromDb!=null)
        {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        user.setActivationCode(UUID.randomUUID().toString());

        if(!file.isEmpty())
        {
            File uploadDir = new File(uploadPath);

            if(!uploadDir.exists())
            {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            user.setFilename(resultFileName);
        }


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
