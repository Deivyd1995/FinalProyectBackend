package com.dh.grup8.IntegradorBackend.model.service.Impl;

import com.dh.grup8.IntegradorBackend.model.dto.CategoryDTO;
import com.dh.grup8.IntegradorBackend.model.entity.Category;
import com.dh.grup8.IntegradorBackend.model.repository.ICategoryRepository;
import com.dh.grup8.IntegradorBackend.model.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDTO findById(Integer id) {
        return null;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public Set<CategoryDTO> findAll() {
        return null;
    }

    //------ MAPPER ------
    private CategoryDTO mapToDTO(Category category) {
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    private Category mapToEntity(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        return category;
    }
}
