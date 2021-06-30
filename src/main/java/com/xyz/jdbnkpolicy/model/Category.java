package com.xyz.jdbnkpolicy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "categories")
public class Category {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String image;
    @DBRef
    private List<Policy> policy;
    public Category() {
        super();
    }

    public Category(String name, String image, List<Policy> policy) {
        super();
        this.name = name;
        this.image = image;
        this.policy = policy;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public List<Policy> getPolicy() {
        return policy;
    }
    public void setPolicy(List<Policy> policy) {
        this.policy = policy;
    }

}
