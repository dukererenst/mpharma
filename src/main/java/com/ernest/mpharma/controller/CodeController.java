/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.mpharma.controller;

import com.ernest.mpharma.entity.Code;
import com.ernest.mpharma.entity.Code;
import com.ernest.mpharma.error.ResourceNotFoundException;
import com.ernest.mpharma.util.CommonContants;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ernest.mpharma.service.CodeRepository;
import org.springframework.data.domain.Page;

/**
 *
 * @author Ernest
 */
@RestController
@RequestMapping(CommonContants.CODE_URL)
public class CodeController implements Serializable{

    @Autowired
    CodeRepository codeService;

    @GetMapping
    public Page<Code> getAllCode(final @PageableDefault(size = 20) Pageable pageable) {
        return  codeService.findAll(pageable);
    }

    @PostMapping
    public Code postCode(@RequestBody Code code) {

        return codeService.saveAndFlush(code);
    }

    @PutMapping
    public Code putCode(@RequestBody Code code) {
        Code cate = codeService.findById(code.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Code", "id", code.getId()));
        cate.setCategeory(code.getCategeory());
        cate.setDiagnosisCode(code.getDiagnosisCode());
        cate.setFullCode(code.getFullCode());
        cate.setFullDescription(code.getFullDescription());
        return codeService.saveAndFlush(cate);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCode(@RequestBody Code code) {
        Code c = codeService.findById(code.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Code", "id", code.getId()));

        codeService.delete(c);

        return ResponseEntity.ok().build();
       
    }

    @GetMapping("/{id}")
    public Code getCode(@PathVariable String id) throws Throwable {
        return codeService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Code Code", "id", id));
    }

}
