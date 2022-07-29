package com.capstone.uzit.product;

import org.hibernate.result.UpdateCountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);

    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException("product with id " + productId +" does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String name, String brand, String category, Double price, LocalDate purchaseDate, LocalDate expirationDate) {
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalStateException(
                    "product with id " + productId +" does not exist"
            ));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(product.getName(),name)) {
            product.setName(name);
        }
        if (brand != null &&
                brand.length() > 0 &&
                !Objects.equals(product.getBrand(),brand)) {
            product.setBrand(brand);
        }
        if (category != null &&
                category.length() > 0 &&
                !Objects.equals(product.getCategory(),category)) {
            product.setCategory(category);
        }

    }
}
