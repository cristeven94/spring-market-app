package com.demo.market.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchaseProductPK implements Serializable {

    @Column(name="id_compra")
    private Integer idPurchase;

    @Column(name="id_producto")
    private Integer idProduct;
}
