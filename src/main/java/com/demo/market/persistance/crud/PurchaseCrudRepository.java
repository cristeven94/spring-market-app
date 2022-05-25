package com.demo.market.persistance.crud;

import com.demo.market.persistance.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase,Integer> {

    Optional<List<Purchase>> findByIdClient(String idClient);

}
