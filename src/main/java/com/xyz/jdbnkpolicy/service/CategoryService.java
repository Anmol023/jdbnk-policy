package com.xyz.jdbnkpolicy.service;

import com.xyz.jdbnkpolicy.model.Category;

import com.xyz.jdbnkpolicy.model.Policy;
import com.xyz.jdbnkpolicy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    PolicyService policyService;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String id){
        return categoryRepository.findById(id).get();
    }

    public void addCategory(Category category) {
        if(category.getPolicy()==null)
            category.setPolicy(new ArrayList<>());
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        String categoryName=categoryRepository.findById(category.getId()).get().getName();
        List<Policy> policies=policyService.getPolicyByCategoryName(categoryName);
        if(!category.getName().equals(categoryName)) {
            policies.forEach(policy -> {
                policy.setCategoryName(category.getName());
                policyService.updatePolicy(policy);
            });
        }
        categoryRepository.save(category);
    }

    public void deleteCategory(String id) {
        categoryRepository.findById(id).get().getPolicy().forEach(policy->policyService.deletePolicy(policy.getId()));
        categoryRepository.deleteById(id);
    }
}
