package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.entity.Product;
import uz.job.task.repository.ProductRepository;
import uz.job.task.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> selectAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> selectProductById(Long id) {
        return productRepository.findById(id);
    }
}
