package com.example.mypain.models;

import com.sun.istack.NotNull;

import javax.persistence.*;


/////////////ДОДЕЛАТЬ СВЯЗКА С PRODUCT_TP //////////////

@Entity
public class product_wh {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproduct_wh;

    /*private String product_number, product_type, product_density, product_conditions, product_count;*/

    int product_number;
    String product_type;
    String product_density;
    String product_conditions;
    int product_count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private users owner;

    public users getOwner() {
        return owner;
    }

    public void setOwner(users owner) {
        this.owner = owner;
    }

    public product_wh() {
    }

    public product_wh(int product_number, String product_type, String product_density, String product_conditions, int product_count, users user) {
        this.product_number = product_number;
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

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    /* public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }*/

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


    /* public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }*/
}
