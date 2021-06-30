package com.xyz.jdbnkpolicy.service;

import com.xyz.jdbnkpolicy.model.Category;
import com.xyz.jdbnkpolicy.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@Service
public class Dummy implements CommandLineRunner {

    @Autowired
    private PolicyService policyService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {

        if (categoryService.getAllCategories().isEmpty()){

            Category[] categories = restTemplate.getForObject("https://22qorolith.execute-api.us-east-1.amazonaws.com/jdbnk/mock-categories",Category[].class);
            for(Category category: categories){
                categoryService.addCategory(category);
            }
            Policy[] policies =restTemplate.getForObject("https://22qorolith.execute-api.us-east-1.amazonaws.com/jdbnk/mock-policies",Policy[].class);
            for(Policy policy: policies){
                policyService.addPolicy(policy);
            }

        }
    }
}
