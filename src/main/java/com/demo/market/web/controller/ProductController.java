package com.demo.market.web.controller;

import com.demo.market.domain.DomainProduct;
import com.demo.market.domain.service.ProductService;
import com.demo.market.persistance.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<DomainProduct> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DomainProduct> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<DomainProduct>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/saveProduct")
    public DomainProduct save(@RequestBody DomainProduct product){
        return productService.save(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
