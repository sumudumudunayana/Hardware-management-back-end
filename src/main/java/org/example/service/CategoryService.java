package org.example.service;

import org.example.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();

    void addCategory(CategoryDto categoryDto);

    void deleteCategoryById(Integer id);

    CategoryDto searchCategoryById(Integer id);

    void updateCategoryById(CategoryDto categoryDto);
}
