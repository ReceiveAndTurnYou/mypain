package com.example.mypain.repositories;

import com.example.mypain.models.product_order;
import com.example.mypain.models.users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface product_orderRepository extends CrudRepository<product_order, Long> {
    List<product_order>findByClient(users user);
}
