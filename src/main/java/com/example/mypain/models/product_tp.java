package com.example.mypain.models;


import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class product_tp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotNull
    private Long product_id;

    @NotNull
    String product_type, description;

    public product_tp()
    {}

    public product_tp(Long product_id, String product_type, String description) {
        this.product_id = product_id;
        this.product_type = product_type;
        this.description = description;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
