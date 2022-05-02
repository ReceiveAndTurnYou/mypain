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
    String login, product_count, productnumber, companyname, address, email, delivery_date;

    public product_order() {
    }

    public product_order(Long idproduct_order, String login, String product_count, String productnumber, String companyname, String address, String email, String delivery_date) {
        this.idproduct_order = idproduct_order;
        this.login = login;
        this.product_count = product_count;
        this.productnumber = productnumber;
        this.companyname = companyname;
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

    public String getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(String productnumber) {
        this.productnumber = productnumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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
