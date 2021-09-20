package uz.job.task.service.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import uz.job.task.entity.Detail;
import uz.job.task.entity.Product;
import uz.job.task.repository.DetailRepository;
import uz.job.task.repository.ProductRepository;
import uz.job.task.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DetailRepository detailRepository;

    public ProductServiceImpl(ProductRepository productRepository, DetailRepository detailRepository) {
        this.productRepository = productRepository;
        this.detailRepository = detailRepository;
    }

    @Override
    public List<Product> selectAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> selectProductById(Long id) {
        return productRepository.findById(id);
    }

    // Criteria 7
    @Override
    public List<Detail> high_demand_products() {
        return detailRepository.findAll().stream()
                .filter(product -> product.getQuantity() > 10).collect(Collectors.toList());
    }

    private Specification<Detail> filterByQuantity(Integer quantity) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("quantity"), quantity));
    }

    // Criteria 8
    @Override
    public List<Detail> bulk_products() {
        return detailRepository.findAll(filterByQuantity(8));
    }
}
