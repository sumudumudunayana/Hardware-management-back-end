package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.CategoryDto;
import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> CategoryArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            CategoryArrayList.add(mapper.map(entity, CategoryDto.class));
        });
        return CategoryArrayList;
    }

    @Override
    public void addCategory(CategoryDto categoryDto) {
        System.out.println(categoryDto);
        repository.save(mapper.map(categoryDto, CategoryEntity.class));
    }

    @Override
    public void deleteCategoryById(Integer id){
        repository.deleteById(id);
    }

    @Override
    public CategoryDto searchCategoryById(Integer id) {
        return mapper.map(repository.findById(id),CategoryDto.class);
    }

    @Override
    public void updateCategoryById(CategoryDto categoryDto) {
        repository.save(mapper.map(categoryDto, CategoryEntity.class));
    }
}
