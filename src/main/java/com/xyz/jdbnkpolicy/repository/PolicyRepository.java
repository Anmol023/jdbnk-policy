package com.xyz.jdbnkpolicy.repository;

import com.xyz.jdbnkpolicy.model.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends MongoRepository<Policy, String> {

    public List<Policy> findByCategoryName(String categoryName);

    public Policy findByName(String name);

    public List<Policy> findByCompany(String id);
}
