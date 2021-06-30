package com.xyz.jdbnkpolicy.controller;

import com.xyz.jdbnkpolicy.exception.PolicyNotFoundException;
import com.xyz.jdbnkpolicy.model.Policy;

import com.xyz.jdbnkpolicy.service.PolicyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(description = "Control policies i.e see, add, delete")
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @ApiOperation(value = "List all policies")
    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @ApiOperation(value = "Select policy by id")
    @GetMapping("/id/{id}")
    public Policy getPolicyById(@PathVariable String id) throws PolicyNotFoundException {
        return policyService.getPolicyById(id);
    }

    @ApiOperation(value = "List all policies by specific provider")
    @GetMapping("/inscmpny/{id}")
    public List<Policy> getPolicyByInscmpny(@PathVariable String id) {
        return policyService.getPolicyByInscmpnyId(id);
    }

    @GetMapping("/{categoryName}")
    public List<Policy> getPolicyByCategoryName(@PathVariable String categoryName) {
        return policyService.getPolicyByCategoryName(categoryName);
    }

    @ApiOperation(value = "Add policy")
    @PostMapping
    public void addPolicy(@RequestBody Policy policy) {
        policyService.addPolicy(policy);
    }

    @ApiOperation(value = "Update policy")
    @PutMapping
    public void updatePolicy(@RequestBody Policy Policy) {
        policyService.updatePolicy(Policy);
    }

    @ApiOperation(value = "Delete policy by id")
    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable String id) {
        policyService.deletePolicy(id);
    }
}
