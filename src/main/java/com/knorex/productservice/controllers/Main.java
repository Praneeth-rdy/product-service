package com.knorex.productservice.controllers;

import com.knorex.productservice.ProductService;
import com.knorex.productservice.exceptions.ResourceNotFoundException;
import com.knorex.productservice.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.knorex.productservice.Constants.ProductsNamespace;

@RestController
public class Main {

    // Inject the ProductService which contains the business logic
    @Autowired
    ProductService productService;
    Logger logger = LoggerFactory.getLogger(Main.class);

    // Dummy controller at index
    @RequestMapping("/")
    public String getIndex() {
        // logger.info("Index page requested");
        return "Welcome to Product Service Application";
    }

    // Fetches and returns all the products
    @GetMapping("/" + ProductsNamespace)
    public List<Product> getProducts() {
        return productService.fetchAllProducts();
    }

    // Creates the product from the data provided in the request body
    @PostMapping("/" + ProductsNamespace)
    public Product createProduct(@RequestBody Product product) {
        // won't be having id as it is auto generated
        // validate if all the necessary fields exist and raise an exception if not
        return productService.saveProduct(product);
    }

    // Fetches and returns the product with the given Id
    // Raises 404 not found exception if the product isn't found
    @GetMapping("/" + ProductsNamespace + "/{id}")
    public Product getProduct(@PathVariable int id) {
        Product fetchedProduct = productService.findProductById(id).orElse(null);
        if (fetchedProduct == null) {
            throw new ResourceNotFoundException("Product with the given product id doesn't exist");
        }
        return fetchedProduct;
    }

    // Updates the product and returns the updated product
    // Raises 404 not found exception if the product isn't found
    @PutMapping("/" + ProductsNamespace + "/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        if (!productService.isProductWithIdExist(id)) {
            // else raise exception to resource not found or entity with id doesn't exist
            throw new ResourceNotFoundException("No product exists with the given product id.");
        }
        product.setId(id);
        return productService.saveProduct(product);
    }

    // Deletes the product with the given Id
    @DeleteMapping("/" + ProductsNamespace + "/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
    }
}
