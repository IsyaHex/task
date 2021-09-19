package uz.job.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.job.task.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
