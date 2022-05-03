package com.example.mypain.repositories;

import com.example.mypain.models.product_tp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface product_tpRepository extends CrudRepository<product_tp, Long> {

    List<product_tp> findByProducttptype(String producttptype);
    /*List<product_tp> findByProduct_tp_description(String product_tp_description);*/
}
