package uz.job.task.service;

import uz.job.task.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> selectAllCategory();
    Optional<Category> selectCategoryById(Long id);
}
