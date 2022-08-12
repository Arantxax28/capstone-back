package com.capstone.uzit.product;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.util.Locale;

@Entity
@Table

public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String brand;
    private String category;
    private Double price;
    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private Integer useCount=0;

    @Transient
    private Long daysLeft;

    public Product() {
    }

    public Product(Long id, String name, String brand, String category, Double price, LocalDate purchaseDate, LocalDate expirationDate, Integer useCount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.useCount = useCount;
    }

    public Product(String name, String brand, String category, Double price, LocalDate purchaseDate, LocalDate expirationDate, Integer useCount) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.useCount = useCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getDaysLeft()  {
        System.out.println(this.expirationDate);
        System.out.println(LocalDate.now());
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), this.expirationDate));
        System.out.println("--------");
        return (ChronoUnit.DAYS.between(LocalDate.now(), this.expirationDate));
    }

    public void setDaysLeft(Long daysLeft) {
        this.daysLeft = daysLeft;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", daysLeft=" + daysLeft +
                ",useCount=" + useCount +
                '}';
    }
}
