package com.demo.market.persistance;

import com.demo.market.domain.DomainPurchase;
import com.demo.market.domain.repository.DomainPurchaseRepository;
import com.demo.market.persistance.crud.PurchaseCrudRepository;
import com.demo.market.persistance.entity.Purchase;
import com.demo.market.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements DomainPurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<DomainPurchase> getAll() {
        return purchaseMapper.toDomainPurchases((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<DomainPurchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId).map(purchases -> purchaseMapper.toDomainPurchases(purchases));
    }

    @Override
    public DomainPurchase save(DomainPurchase domainPurchase) {
        Purchase purchase = purchaseMapper.toPurchase(domainPurchase);
        purchase.getPurchaseProducts().forEach(purchaseProduct -> purchaseProduct.setPurchase(purchase));
        return purchaseMapper.toDomainPurchase(purchaseCrudRepository.save(purchase));
    }
}
