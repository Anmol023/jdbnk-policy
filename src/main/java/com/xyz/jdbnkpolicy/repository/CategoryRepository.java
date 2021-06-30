package com.xyz.jdbnkpolicy.repository;


import com.xyz.jdbnkpolicy.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query(value = "{ 'name' : ?0 }", fields = "{ 'productList' : 1 }")
    public Category findPolicyListByCategoryName(String categoryName);

    public Category findByPolicyName(String string);

    public String findNameByPolicyName(String string);

    public Category findByName(String name);

}