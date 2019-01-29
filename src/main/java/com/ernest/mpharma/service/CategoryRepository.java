/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.mpharma.service;

import com.ernest.mpharma.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ernest
 */
@Repository
public interface  CategoryRepository extends CrudRepository<Category, String> {
  //List<Category> findAllByPrice(double price, Pageable pageable);
    public Page<Category> findAll(Pageable pageable);
   
}
