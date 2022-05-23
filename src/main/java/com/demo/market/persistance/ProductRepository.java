package com.demo.market.persistance;

import com.demo.market.persistance.crud.ProductCrudRepository;
import com.demo.market.persistance.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory){
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getScarce(int quantity){
        return productCrudRepository.findByStockQuantityLessThanAndState(quantity,true);
    }
}
