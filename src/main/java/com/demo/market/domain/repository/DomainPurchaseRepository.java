package com.demo.market.domain.repository;

import com.demo.market.domain.DomainPurchase;

import java.util.List;
import java.util.Optional;

public interface DomainPurchaseRepository {

    List<DomainPurchase> getAll();

    Optional<List<DomainPurchase>> getByClient(String clientId);

    DomainPurchase save(DomainPurchase purchase);
}
