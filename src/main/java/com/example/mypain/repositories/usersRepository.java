package com.example.mypain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.mypain.models.users;

import java.util.List;

public interface usersRepository extends JpaRepository<users, Long> {
    users findByusername(String username);

    List<users> findByLogin(String login);
}
