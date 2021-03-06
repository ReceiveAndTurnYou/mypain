package com.example.mypain.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import com.example.mypain.models.product_tp;

@Entity
public class product_wh {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproduct_wh;

    int productnumber;
    String product_type;
    String product_density;
    String product_conditions;
    int product_count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private users owner;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="product_tp_id")
    private product_tp type;

    public product_tp getType() {
        return type;
    }

    public void setType(product_tp type) {
        this.type = type;
    }

    public users getOwner() {
        return owner;
    }

    public void setOwner(users owner) {
        this.owner = owner;
    }

    public product_wh() {
    }

    public product_wh(int productnumber, int product_count, users owner, product_tp producttptype) {
        this.productnumber = productnumber;
        this.product_count = product_count;
        this.owner = owner;
        this.type = producttptype;
    }

//    public product_wh(int productnumber, String product_type, String product_density, String product_conditions, int product_count, users owner, product_tp producttptype) {
//        this.productnumber = productnumber;
//        this.product_type = product_type;
//        this.product_density = product_density;
//        this.product_conditions = product_conditions;
//        this.product_count = product_count;
//        this.owner = owner;
//        this.type = producttptype;
//    }

    public product_wh(int productnumber, String product_type, String product_density, String product_conditions, int product_count, users user) {
        this.productnumber = productnumber;
        this.product_type = product_type;
        this.product_density = product_density;
        this.product_conditions = product_conditions;
        this.product_count = product_count;
        this.owner = user;
    }

    public Long getIdproduct_wh() {
        return idproduct_wh;
    }

    public void setIdproduct_wh(Long idproduct_wh) {
        this.idproduct_wh = idproduct_wh;
    }

    public int getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(int productnumber) {
        this.productnumber = productnumber;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_density() {
        return product_density;
    }

    public void setProduct_density(String product_density) {
        this.product_density = product_density;
    }

    public String getProduct_conditions() {
        return product_conditions;
    }

    public void setProduct_conditions(String product_conditions) {
        this.product_conditions = product_conditions;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

}
