/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.mpharma.controller;

import com.ernest.mpharma.entity.Category;
import com.ernest.mpharma.error.ResourceNotFoundException;
import com.ernest.mpharma.util.CommonContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ernest.mpharma.service.CategoryRepository;
import org.springframework.data.web.PageableDefault;

/**
 *
 * @author Ernest
 */
@RestController
@RequestMapping(CommonContants.CATEGORY_URL)
public class CategoryController {

    @Autowired
    CategoryRepository categoryService;

    @GetMapping
    public Page<Category> getAllCategory(final @PageableDefault(size = 20) Pageable pageable) {
       
       return  categoryService.findAll(pageable);
     
    }

    @PostMapping
    public Category postCategory(@RequestBody Category category) {

        return categoryService.save(category);
    }

    @PutMapping
    public Category putCategory(@RequestBody Category category) {
        Category cate = categoryService.findById(category.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", category.getId()));
        cate.setCategoryCode(category.getCategoryCode());
        cate.setCategoryTitle(category.getCategoryTitle());
        return categoryService.save(cate);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@RequestBody Category category) {
        Category c = categoryService.findById(category.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", category.getId()));

        categoryService.delete(c);

        return ResponseEntity.ok().build();
       
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable String id) throws Throwable {
        return categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Code Category", "id", id));
    }

}
