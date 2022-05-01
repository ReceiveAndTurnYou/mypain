package com.example.mypain.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class product_tp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_tp_id;

    @NotNull
    String product_tp_type, product_tp_description;


    public product_tp()
    {}

  /*  public product_tp(Long product_tp_id, String product_tp_type, String product_tp_description, Set<product_wh> product_whSet) {
        this.product_tp_id = product_tp_id;
        this.product_tp_type = product_tp_type;
        this.product_tp_description = product_tp_description;
        this.product_whSet = product_whSet;
    }*/

    public Long getProduct_tp_id() {
        return product_tp_id;
    }

    public void setProduct_tp_id(Long product_tp_id) {
        this.product_tp_id = product_tp_id;
    }

    public String getProduct_tp_type() {
        return product_tp_type;
    }

    public void setProduct_tp_type(String product_tp_type) {
        this.product_tp_type = product_tp_type;
    }

    public String getProduct_tp_description() {
        return product_tp_description;
    }

    public void setProduct_tp_description(String product_tp_description) {
        this.product_tp_description = product_tp_description;
    }

    /*public void setProduct_whSet(Set<product_wh> product_whSet) {
        this.product_whSet = product_whSet;
    }*/
}
