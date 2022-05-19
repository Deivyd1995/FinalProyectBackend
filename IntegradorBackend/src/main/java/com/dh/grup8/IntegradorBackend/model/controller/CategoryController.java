package com.dh.grup8.IntegradorBackend.model.controller;

import com.dh.grup8.IntegradorBackend.model.dto.CategoryDTO;
import com.dh.grup8.IntegradorBackend.model.service.Impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> search(@Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.create(categoryDTO);
        return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.CREATED);
    }

    @GetMapping("/id/{categoryId}")
    public ResponseEntity<?> findByID(@PathVariable Long categoryId){
        CategoryDTO categoryDTO = categoryService.findById(categoryId);
        return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll(){
        Set<CategoryDTO> categoryDTOList=categoryService.findAll();
        return new ResponseEntity<Set<CategoryDTO>>(categoryDTOList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/categoryId")
    public ResponseEntity<?> delete(@PathVariable Long categoryId){
        categoryService.deleteById(categoryId);
        return new ResponseEntity<>("Category with id: "+ categoryId + " is delete", HttpStatus.OK);
    }

}
