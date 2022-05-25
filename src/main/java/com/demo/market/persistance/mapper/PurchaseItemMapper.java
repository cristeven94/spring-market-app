package com.demo.market.persistance.mapper;

import com.demo.market.domain.DomainPurchase;
import com.demo.market.domain.DomainPurchaseItem;
import com.demo.market.persistance.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "state", target = "active")
    })
    DomainPurchaseItem toDomainPurchaseItem(PurchaseProduct purchaseProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(DomainPurchaseItem purchaseItem);
}
