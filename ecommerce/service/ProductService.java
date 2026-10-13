package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Add Product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product By ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    // Update Product
    public Product updateProduct(Long id, Product product) {

        Product existing = productRepository.findById(id).orElseThrow();

        existing.setName(product.getName());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setDescription(product.getDescription());
        existing.setImageUrl(product.getImageUrl());

        return productRepository.save(existing);
    }

    // Delete Product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    public void reduceStock(Long productId) {

        Product product = productRepository.findById(productId).orElse(null);

        if (product != null && product.getQuantity() > 0) {

            product.setQuantity(product.getQuantity() - 1);

            productRepository.save(product);

        }

    }
    
}