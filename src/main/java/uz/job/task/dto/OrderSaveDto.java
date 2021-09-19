package uz.job.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import uz.job.task.entity.Customer;
import uz.job.task.entity.Product;

import javax.validation.constraints.NotBlank;

public class OrderSaveDto {
    private Long id;
    @NotBlank
    @JsonProperty
    private Customer customer;
    @NotBlank
    @JsonProperty
    private Product product;
    @NotBlank
    @JsonProperty
    private Integer quantity;

//    public OrderSaveDto(Customer customer, Product product, Integer quantity) {
//        this.customer = customer;
//        this.product = product;
//        this.quantity = quantity;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
