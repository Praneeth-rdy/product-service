package com.knorex.productservice;

import com.knorex.productservice.dao.ProductRepository;
import com.knorex.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Injecting the product repository
    @Autowired
    ProductRepository productRepository;

    // Saves and returns the saved product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Deletes the product by Id
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    // Checks and return boolean if the product with id exists
    public boolean isProductWithIdExist(int id) {
        return productRepository.existsById(id);
    }

    // Returns the list of all products
    public List<Product> fetchAllProducts(){
        return productRepository.findAll();
    }

    // Finds and returns the product with Id
    public Optional<Product> findProductById(int id) {
        return productRepository.findById(id);
    }

}
