package com.xyz.jdbnkpolicy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "policies")
public class Policy {
    @Id
    private String id;
    private String name;
    private String company;
    private String categoryName;
    private String image;
    private String cover;
    private String claimSettled;
    private String premium;

    public Policy() {
        super();
    }

    public Policy(String name, String company, String categoryName, String premium, String image, String cover, String claimSettled) {
        super();
        this.name = name;
        this.company = company;
        this.categoryName = categoryName;
        this.premium = premium;
        this.image = image;
        this.cover = cover;
        this.claimSettled= claimSettled;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public String getPremium() {
        return premium;
    }


    public void setPremium(String premium) {
        this.premium = premium;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getClaimSettled() {
        return claimSettled;
    }

    public void setClaimSettled(String claimSettled) {
        this.claimSettled = claimSettled;
    }

}