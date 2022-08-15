package com.capstone.uzit.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Example;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @CrossOrigin
    @GetMapping(path = "/makeup")
    public List<Product> getMakeup() {
        return productService.getMakeup();
    }
    @CrossOrigin
    @GetMapping(path = "/skincare")
    public List<Product> getSkincare() {
        return productService.getSkincare();
    }
    @CrossOrigin
    @GetMapping(path = "/subscriptions")
    public List<Product> getSubscriptions() {
        return productService.getSubscriptions();
    }


    @CrossOrigin
    @PostMapping
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @CrossOrigin
    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }
    @CrossOrigin
    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) LocalDate purchaseDate,
            @RequestParam(required = false) LocalDate expirationDate
            ){
        productService.updateProduct(productId,name,brand,category,price,purchaseDate,expirationDate);
    }

//    @CrossOrigin
//    @PatchMapping(path = "{productId}")
//    public void updateUse(
//            @PathVariable("productId") Long productId,
//            @RequestParam(required = false) Integer useCount
//    ){
//        productService.updateUse(productId, useCount);
//    }

    @CrossOrigin
    @PatchMapping(path = "/increment/{productId}")
    public void addCPU(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) Integer useCount,
            @RequestParam(required = false) Double costPerUse,
            @RequestParam(required = false) Double price
    ){
        productService.addCPU(productId, useCount, costPerUse, price);
    }

    @CrossOrigin
    @PatchMapping(path = "/decrement/{productId}")
    public void removeCPU(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) Integer useCount,
            @RequestParam(required = false) Double costPerUse,
            @RequestParam(required = false) Double price
    ){
        productService.removeCPU(productId, useCount, costPerUse, price);
    }
}
