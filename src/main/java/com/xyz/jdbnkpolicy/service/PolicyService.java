package com.xyz.jdbnkpolicy.service;

import com.xyz.jdbnkpolicy.exception.PolicyNotFoundException;
import com.xyz.jdbnkpolicy.model.Category;
import com.xyz.jdbnkpolicy.model.Policy;
import com.xyz.jdbnkpolicy.repository.CategoryRepository;
import com.xyz.jdbnkpolicy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PolicyRepository policyRepository;

    public List<Policy> getAllPolicies(){
        return policyRepository.findAll();
    }

    public Policy getPolicyById(String id) throws PolicyNotFoundException{
        Optional<Policy> policy =policyRepository.findById(id);
        if(policy.isPresent())
            return policy.get();
        else
            throw new PolicyNotFoundException("Policy Not Found");
    }

    public List<Policy> getPolicyByInscmpnyId(String id){
        return policyRepository.findByCompany(id);
    }
    public void addPolicy(Policy policy){
        policyRepository.save(policy);
        Category category= categoryRepository.findByName(policy.getCategoryName());
        List<Policy> Policy =category.getPolicy();
        if(Policy==null)
            Policy=new ArrayList<>();
        Policy.add(policyRepository.findByName(policy.getName()));
        category.setPolicy(Policy);
        categoryRepository.save(category);
    }

    public void deletePolicy(String id){
        Policy policy = policyRepository.findById(id).get();
        Category category = categoryRepository.findByName(policy.getCategoryName());
        List<Policy> Policy = category.getPolicy();
        Policy.remove(policy);
        category.setPolicy(Policy);
        categoryRepository.save(category);
        policyRepository.deleteById(id);
    }

    public void updatePolicy(Policy policy){
        Policy existingPolicy = policyRepository.findById(policy.getId()).get();
        if(existingPolicy.getCategoryName().equals(policy.getCategoryName())){
            policyRepository.save(policy);
            Category category = categoryRepository.findByName(policy.getCategoryName());
            categoryRepository.save(category);
        }
        else {
            deletePolicy(policy.getId());
            addPolicy(policy);
        }
    }

    public List<Policy> getPolicyByCategoryName(String categoryName){
        if (categoryName.equals("COMPOSITE"))
            return policyRepository.findAll();
        else
            return policyRepository.findByCategoryName(categoryName);
    }
}
