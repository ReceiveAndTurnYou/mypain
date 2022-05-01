package com.example.mypain.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class delivery_company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iddelivery_company;

    @NotNull
    String company_name, company_description;
    int trust_factor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private users owner;

    public users getOwner() {
        return owner;
    }

    public void setOwner(users owner) {
        this.owner = owner;
    }

    public delivery_company(String company_name, String company_description, int trust_factor, users user) {
        this.company_name = company_name;
        this.company_description = company_description;
        this.trust_factor = trust_factor;
        this.owner = user;
    }

    public delivery_company() {
    }

    public delivery_company(Long iddelivery_company, String company_name, String company_description, int trust_factor) {
        this.iddelivery_company = iddelivery_company;
        this.company_name = company_name;
        this.company_description = company_description;
        this.trust_factor = trust_factor;
    }

    public Long getIddelivery_company() {
        return iddelivery_company;
    }

    public void setIddelivery_company(Long iddelivery_company) {
        this.iddelivery_company = iddelivery_company;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_description() {
        return company_description;
    }

    public void setCompany_description(String company_description) {
        this.company_description = company_description;
    }

    public int getTrust_factor() {
        return trust_factor;
    }

    public void setTrust_factor(int trust_factor) {
        this.trust_factor = trust_factor;
    }
}
