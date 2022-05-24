package com.demo.market.domain.service;

import com.demo.market.domain.DomainProduct;
import com.demo.market.domain.repository.DomainProductRepository;
import com.demo.market.persistance.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private DomainProductRepository domainProductRepository;

    public List<DomainProduct> getAll(){

        return domainProductRepository.getAll();
    }

    public Optional<DomainProduct> getProduct(int productId){

        return domainProductRepository.getProduct(productId);
    }

    public Optional<List<DomainProduct>> getByCategory(int categoryId){
        return domainProductRepository.getByCategory(categoryId);
    }

    public DomainProduct save(DomainProduct product) {
        return domainProductRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            domainProductRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
