package org.example.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.CategoryDto;
import org.example.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class CategoryController {
    final CategoryService service;

    @GetMapping("/get-all")
    public List<CategoryDto> getItem(){
        return service.getAll();
    }

    @PostMapping("/add-category")
    public void addCategory(@RequestBody CategoryDto categoryDto){
        log.info("updated-> {}",categoryDto);
        service.addCategory(categoryDto);
    }

    @GetMapping("/search-by-id/{id}")
    public CategoryDto getCategoryById(@PathVariable Integer id){
        return service.searchCategoryById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCategoryById(@PathVariable Integer id){
        service.deleteCategoryById(id);
    }

    @PutMapping("/update-category")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCategoryById(@RequestBody CategoryDto categoryDto){
        service.updateCategoryById(categoryDto);
    }
}
