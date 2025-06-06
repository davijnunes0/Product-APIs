package com.davijnunes.product_application.services;

import org.springframework.stereotype.Service;
import com.davijnunes.product_application.repository.ProductRepository;
import com.davijnunes.product_application.models.Product;
import java.util.List;
import com.davijnunes.product_application.exceptions.ResourceNotFoundException;
import java.util.UUID;

@Service
public class ProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product searchById(UUID productId){
          return productRepository.findById(productId).
        orElseThrow(() -> new ResourceNotFoundException("Não foi possivel achar o produto com esse UUID específicado."));
    }

    public void deleteProduct(UUID productId){
        if(!productRepository.existsById(productId)){
            throw new ResourceNotFoundException("Não foi possivel encontrar o produto com o (UUID: "  + productId + " )");
        }
        productRepository.deleteById(productId);
    }


}