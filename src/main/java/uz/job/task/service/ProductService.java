package uz.job.task.service;

import uz.job.task.entity.Detail;
import uz.job.task.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> selectAllProduct();
    Optional<Product> selectProductById(Long id);

    // Criteria 7
    List<Detail> high_demand_products();
    // Criteria 8
    List<Detail> bulk_products();
}
