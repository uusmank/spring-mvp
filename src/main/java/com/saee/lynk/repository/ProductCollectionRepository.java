package com.saee.lynk.repository;

import com.saee.lynk.model.Product;
import com.saee.lynk.model.Status;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductCollectionRepository {
    private final List<Product> productList  = new ArrayList<>();

    public ProductCollectionRepository(){

    }

    public  List<Product> findAll()
    {
        return this.productList;
    }
    public Optional<Product> findById(Integer id)
    {
        return productList.stream().filter(p -> p.id().equals(id)).findFirst();
    }
    @PostConstruct
    private void  init(){
        Product p =new Product(
                1,
                "iPhone",
                1000.00F,
                1.50F,
                100,
                Status.ACTIVE,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        productList.add(p);
    }


    public void saveProduct(Product product) {
        productList.removeIf(p->p.id().equals(product.id()));
        productList.add(product);
    }

    public boolean existsById(Integer id) {
        return productList.stream().filter(p -> p.id().equals(id)).count()>0;
    }

    public void deleteById(Integer id) {
        productList.removeIf(p->p.id().equals(id));
    }
}
