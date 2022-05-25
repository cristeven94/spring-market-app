package com.demo.market.persistance.mapper;

import com.demo.market.domain.DomainPurchase;
import com.demo.market.persistance.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "purchaseProducts", target = "items")
    })
    DomainPurchase toDomainPurchase(Purchase purchase);

    List<DomainPurchase> toDomainPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(DomainPurchase domainPurchase);
}
