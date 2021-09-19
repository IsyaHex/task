package uz.job.task.service;

import uz.job.task.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> selectAllProduct();
    Optional<Product> selectProductById(Long id);
}
