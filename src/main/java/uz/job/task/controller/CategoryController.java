package uz.job.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.job.task.entity.Category;
import uz.job.task.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/list")
    public List<Category> getAllCategory() {
        return categoryService.selectAllCategory();
    }

    @GetMapping(path = "{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.selectCategoryById(id)
                .orElse(null);
    }
}
