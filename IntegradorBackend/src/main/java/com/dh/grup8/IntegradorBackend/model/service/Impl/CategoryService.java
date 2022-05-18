package com.dh.grup8.IntegradorBackend.model.service.Impl;

import com.dh.grup8.IntegradorBackend.model.dto.CategoryDTO;
import com.dh.grup8.IntegradorBackend.model.entity.Category;
import com.dh.grup8.IntegradorBackend.model.repository.ICategoryRepository;
import com.dh.grup8.IntegradorBackend.model.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDTO findById(Long id) {
        CategoryDTO response = null;
        Category category = categoryRepository.findById(id).get();
        if (category != null) {
            response = mapToDTO(category);
        }
        return response;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category categorySaveResponse = categoryRepository.save(mapToEntity(categoryDTO));
        CategoryDTO responseCategoryDTO = mapToDTO(categorySaveResponse);
        return responseCategoryDTO;
    }

    @Override
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = mapToEntity(categoryDTO);
        Category responseCategorySave = categoryRepository.save(category);
        return mapToDTO(responseCategorySave);
    }

    @Override
    public Set<CategoryDTO> findAll() {
        List<Category> category_list = categoryRepository.findAll();
        Set<CategoryDTO> categoryDTO_list = new HashSet<>();
        for (Category cat : category_list) {
            categoryDTO_list.add(mapToDTO(cat));
        }
        return categoryDTO_list;
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
