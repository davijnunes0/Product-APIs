package com.davijnunes.product_application.repository;

import com.davijnunes.product_application.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product,UUID>{
    
}
