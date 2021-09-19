package uz.job.task.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.job.task.entity.Detail;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    @EntityGraph(attributePaths = {"order", "product"})
    List<Detail> findAll();
}
