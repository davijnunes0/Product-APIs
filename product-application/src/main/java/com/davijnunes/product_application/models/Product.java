package com.davijnunes.product_application.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;

    @Column(nullable = false)
    private String productName;

    @Column(columnDefinition = "TEXT")
    private String productDescription;

    @Column(nullable = false)
    private Double productPrice;

    public Product() {}

    public void setProductId(UUID productId){
        this.productId = productId;
    }

    public UUID getProductId() {return this.productId;}

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductName() {return this.productName;}

    public void setProductDescription(String productDescription){
        this.productDescription = productDescription;
    }

    public String getProductDescription() {return this.productDescription;}

    public void setPrice(Double productPrice){
        this.productPrice = productPrice;
    }

    public Double getPrice() {return this.productPrice;}

    @Override
    public String toString() {
        return "Product [getProductId()=" + getProductId() + ", getProductName()=" + getProductName()
                + ", getProductDescription()=" + getProductDescription() + ", getPrice()=" + getPrice() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }


    


}
