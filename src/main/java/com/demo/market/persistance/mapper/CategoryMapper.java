package com.demo.market.persistance.mapper;

import com.demo.market.domain.DomainCategory;
import com.demo.market.persistance.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    DomainCategory toDomainCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(DomainCategory domainCategory);


}
