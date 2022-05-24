package com.demo.market.persistance;

import com.demo.market.domain.DomainProduct;
import com.demo.market.domain.repository.DomainProductRepository;
import com.demo.market.persistance.crud.ProductCrudRepository;
import com.demo.market.persistance.entity.Product;
import com.demo.market.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements DomainProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<DomainProduct> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return productMapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<DomainProduct>> getByCategory(int categoryId){
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<DomainProduct>> getScarceProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndState(quantity,true);
        return products.map(product -> productMapper.toDomainProducts(product));
    }

    @Override
    public Optional<DomainProduct> getProduct(int productId){
        return productCrudRepository.findById(productId).map(product -> productMapper.toDomainProduct(product));
    }

    @Override
    public DomainProduct save(DomainProduct domainProduct) {
        Product product = productMapper.toProduct(domainProduct);
        return productMapper.toDomainProduct(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }
}
