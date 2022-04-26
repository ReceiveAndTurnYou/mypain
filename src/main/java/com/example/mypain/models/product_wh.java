package com.example.mypain.models;

import com.sun.istack.NotNull;

import javax.persistence.*;


/////////////ДОДЕЛАТЬ СВЯЗКА С PRODUCT_TP //////////////

@Entity
public class product_wh {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproduct_wh;

    @NotNull
    String product_number, product_type, product_density, product_conditions, product_count;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_type_id", referencedColumnName = "product_tp_id")
    private product_tp product_Ttp;


    public product_tp getProduct_Ttp() {
        return product_Ttp;
    }

    public product_wh() {
    }

    public product_wh(Long idproduct_wh, String product_number, String product_type, String product_density, String product_conditions, String product_count) {
        this.idproduct_wh = idproduct_wh;
        this.product_number = product_number;
        this.product_type = product_type;
        this.product_density = product_density;
        this.product_conditions = product_conditions;
        this.product_count = product_count;
    }

    public Long getIdproduct_wh() {
        return idproduct_wh;
    }

    public void setIdproduct_wh(Long idproduct_wh) {
        this.idproduct_wh = idproduct_wh;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
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

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }
}
