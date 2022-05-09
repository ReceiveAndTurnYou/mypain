package com.example.mypain.models;

import com.sun.istack.NotNull;

import javax.persistence.*;


////////////////// ДОРАБОТАТЬ И СВЯЗКИ /////////////////////


@Entity
public class product_order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproduct_order;

    /*@NotNull
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
    }*/

    public Long getIdproduct_order() {
        return idproduct_order;
    }

    public void setIdproduct_order(Long idproduct_order) {
        this.idproduct_order = idproduct_order;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private users client;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="product_tp_id")
    private product_tp productTypeName;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="iddelivery_company")
    private delivery_company company;

    private String orderDate;

    public product_order() {
    }

    public product_order(users user, product_tp productTypeName, delivery_company company, String orderDate) {
        this.client = user;
        this.productTypeName = productTypeName;
        this.company = company;
        this.orderDate = orderDate;
    }

    public users getClient() {
        return client;
    }

    public void setClient(users client) {
        this.client = client;
    }

    public product_tp getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(product_tp productTypeName) {
        this.productTypeName = productTypeName;
    }

    public delivery_company getCompany() {
        return company;
    }

    public void setCompany(delivery_company company) {
        this.company = company;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}
