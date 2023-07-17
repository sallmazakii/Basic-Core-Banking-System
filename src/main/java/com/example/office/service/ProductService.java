package com.example.office.service;

import com.example.office.domain.Product;
import com.example.office.domain.ProductDTO;
import com.example.office.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    final com.example.office.repo.productRepo productRepo;

    public List<Product> retrieveAllProducts() {
        return productRepo.findAll();
    }

    public Product retrieveProductById(Long id){
        return productRepo.findById(id).orElseThrow(
                ()
                        -> new NotFoundException(
                        "NO PRODUCT PRESENT WITH ID = " + id));
    }

    public Product retrieveProductByName(String name){
        return productRepo.findByName(name);
    }

    public Product createProduct (ProductDTO productDTO){
        return productRepo.save(Product.createProduct(productDTO));
    }

    public Product updateProduct (Long id, ProductDTO productDTO){
        Product product= productRepo.findById(id).orElseThrow( ()
                -> new NotFoundException(
                "NO USER PRESENT WITH ID = " + id));
        Product newproduct =   Product.updateProduct(productDTO,product );
        return productRepo.save(newproduct);
    }
    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }
    public void deleteAllProducts() {
        productRepo.deleteAll();
    }
}
