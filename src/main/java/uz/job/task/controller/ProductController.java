package uz.job.task.controller;

import org.springframework.web.bind.annotation.*;
import uz.job.task.entity.Product;
import uz.job.task.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> getAllProduct() {
        return productService.selectAllProduct();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.selectProductById(id)
                .orElse(null);
    }

    @PostMapping
    public void addProduct() {

    }
}
