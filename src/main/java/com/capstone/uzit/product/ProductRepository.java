package com.capstone.uzit.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.query.QueryByExampleExecutor;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long>, QueryByExampleExecutor<Product> {
//    @Query(value= "from Product where category = 'Makeup'")
//    List<Product> findByCategory(String category);'\
@Query(value= "from Product where category = :category")
List<Product> findByCategory(@Param("category") String category);

}
