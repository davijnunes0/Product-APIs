package com.davijnunes.product_application.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davijnunes.product_application.services.ProductService;

import jakarta.validation.Valid;

import com.davijnunes.product_application.dtos.ProductRecordDto;
import com.davijnunes.product_application.exceptions.ResourceNotFoundException;
import com.davijnunes.product_application.models.Product;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="productId") UUID productId) {
        Product product = productService.searchById(productId);

        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
            body(new ResourceNotFoundException("Produto com esse UUID não foi encontrado"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

     @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var product = new Product();
        BeanUtils.copyProperties(productRecordDto, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
        
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="productId") UUID productId, @RequestBody @Valid ProductRecordDto productRecordDto) {
        Product product = productService.searchById(productId);
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Não foi possivel achar o produto com UUID específicado."));

        }
        BeanUtils.copyProperties(productRecordDto, product);
        return ResponseEntity.status(HttpStatus.OK).body(productService.saveProduct(product));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "productId") UUID productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
