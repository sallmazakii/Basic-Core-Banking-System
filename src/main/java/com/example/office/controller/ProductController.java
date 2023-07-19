package com.example.office.controller;

import com.example.office.domain.Office;
import com.example.office.domain.OfficeDTO;
import com.example.office.domain.Product;
import com.example.office.domain.ProductDTO;
import com.example.office.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class ProductController {
    ProductService productService;
    @GetMapping("/retrieveAllProducts")
    public List<Product> retrieveAllProducts(){
        return productService.retrieveAllProducts();
    }

    @GetMapping("/retrieveProductById/{id}")
    public Product retrieveProductById(@PathVariable("id") Long id){
        return productService.retrieveProductById(id);
    }

    @GetMapping("/retrieveProductByName/{name}")
    public Product retrieveProductByName(@PathVariable("name") String name){
        return productService.retrieveProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestParam Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/createProduct")
    public Product createProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }
    @DeleteMapping("/deleteAllProducts")
    public void deleteAllProducts(){
        productService.deleteAllProducts();
    }
}
