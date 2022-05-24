package com.demo.market.domain.repository;

import com.demo.market.domain.DomainProduct;

import java.util.List;
import java.util.Optional;

public interface DomainProductRepository {

    List<DomainProduct> getAll();

    Optional<List<DomainProduct>> getByCategory(int categoryId);

    Optional<List<DomainProduct>> getScarceProducts(int quantity);

    Optional<DomainProduct> getProduct(int productId);

    DomainProduct save(DomainProduct domainProduct);

    void delete(int productId);
}
