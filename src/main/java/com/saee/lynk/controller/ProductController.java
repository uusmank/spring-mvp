package com.saee.lynk.controller;

import com.saee.lynk.model.Product;
import com.saee.lynk.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("")
    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        if(!this.productRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        return this.productRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addProduct(@Valid @RequestBody Product product){
        this.productRepository.save(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable Long id){

        if(!this.productRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        this.productRepository.save(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        if(!this.productRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        this.productRepository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Product> findByName(@PathVariable String keyword){
        return this.productRepository.findAllByNameContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Product> findByStatus(@PathVariable String status){
        return this.productRepository.findByStatus(status);
    }
}
