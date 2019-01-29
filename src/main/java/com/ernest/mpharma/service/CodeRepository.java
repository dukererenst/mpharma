/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.mpharma.service;

import com.ernest.mpharma.entity.Code;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ernest
 */
@Repository
public interface  CodeRepository extends JpaRepository<Code, String> {
   public Page<Code> findAll(Pageable pageable);
}
