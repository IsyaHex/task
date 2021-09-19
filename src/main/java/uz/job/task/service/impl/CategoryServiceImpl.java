package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.entity.Category;
import uz.job.task.repository.CategoryRepository;
import uz.job.task.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> selectAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> selectCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
