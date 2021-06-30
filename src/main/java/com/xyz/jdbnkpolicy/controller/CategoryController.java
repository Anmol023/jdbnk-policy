package com.xyz.jdbnkpolicy.controller;

import com.xyz.jdbnkpolicy.model.Category;
import com.xyz.jdbnkpolicy.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(description = "Control categories")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ApiOperation(value = "List all categories")
    private List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get category by id")
    private Category getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    @ApiOperation(value = "Add category")
    private void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping
    @ApiOperation(value = "Update category")
    private void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete category")
    private void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }

}