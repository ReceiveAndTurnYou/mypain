package com.example.mypain.repositories;

import com.example.mypain.models.delivery_company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface delivery_companyRepository extends CrudRepository<delivery_company, Long> {

    List<delivery_company> findByCompanyname(String companyname);
}
