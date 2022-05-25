package com.demo.market.web.controller;

import com.demo.market.domain.DomainPurchase;
import com.demo.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<DomainPurchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<DomainPurchase>> getByClient(@PathVariable("clientId") String clientId){
        return purchaseService.getByClient(clientId)
                .filter(domainPurchases -> !domainPurchases.isEmpty())
                .map(domainPurchases -> new ResponseEntity<>(domainPurchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/savePurchase")
    public ResponseEntity<DomainPurchase> save(@RequestBody DomainPurchase domainPurchase){
        return new ResponseEntity<>(purchaseService.save(domainPurchase),HttpStatus.CREATED);
    }
}
