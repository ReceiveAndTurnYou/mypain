package com.example.mypain.models;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


////////////////// ДОРАБОТАТЬ И СВЯЗКИ /////////////////////


@Entity
public class product_order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproduct_order;

    @NotNull
    String login, product_count, product_number, company_name, address, email, delivery_date;

    public product_order() {
    }

    public product_order(Long idproduct_order, String login, String product_count, String product_number, String company_name, String address, String email, String delivery_date) {
        this.idproduct_order = idproduct_order;
        this.login = login;
        this.product_count = product_count;
        this.product_number = product_number;
        this.company_name = company_name;
        this.address = address;
        this.email = email;
        this.delivery_date = delivery_date;
    }

    public Long getIdproduct_order() {
        return idproduct_order;
    }

    public void setIdproduct_order(Long idproduct_order) {
        this.idproduct_order = idproduct_order;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }
}
