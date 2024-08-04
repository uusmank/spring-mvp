package com.saee.lynk.repository;

import com.saee.lynk.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Long> {

    List<Product> findAllByNameContains (String keyword);


    @Query("""
            select * from Product where status = :status
             """)
    List<Product> findByStatus(@Param("status") String status);
}
