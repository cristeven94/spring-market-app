package com.demo.market.persistance.mapper;

import com.demo.market.domain.DomainProduct;
import com.demo.market.persistance.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "idCategory"),
            @Mapping(source = "price", target = "salePrice"),
            @Mapping(source = "stock", target = "stockQuantity"),
            @Mapping(source = "active", target = "state"),
            @Mapping(source = "category", target = "category")
    })
    DomainProduct toDomainProduct(Product product);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(DomainProduct product);

    List<DomainProduct> toDomainProducts(List<Product> products);
}
