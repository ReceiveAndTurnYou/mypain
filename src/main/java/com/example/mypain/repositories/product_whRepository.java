package com.example.mypain.repositories;

import com.example.mypain.models.product_wh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface product_whRepository extends JpaRepository<product_wh, Long> {

    List<product_wh> findByProductnumber(int productnumber);
}
