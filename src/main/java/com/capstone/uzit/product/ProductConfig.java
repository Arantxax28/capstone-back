package com.capstone.uzit.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            ProductRepository repository) {
        return args -> {
//            Product cloudPaint = new Product(
//                    "Cloud Paint",
//                    "Glossier",
//                    "Makeup",
//                    20.00,
//                    LocalDate.of(2022, Month.JULY,27),
//                    LocalDate.of(2023, Month.JANUARY,27)
//            );
//            Product airBrow = new Product(
//                    "Air Brow Eyebrow Gel",
//                    "Kosas",
//                    "Makeup",
//                    24.00,
//                    LocalDate.of(2022, Month.MAY,2),
//                    LocalDate.of(2022, Month.NOVEMBER,2)
//            );
            repository.saveAll(
                    List.of()
            );
        };
    }
}
