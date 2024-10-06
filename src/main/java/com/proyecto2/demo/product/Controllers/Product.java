package com.proyecto2.demo.product.Controllers;

import com.proyecto2.demo.product.Service.ProductService;
import com.proyecto2.demo.product.models.ProductModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class Product {
    private final ProductService productService;
    public Product (ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/getProducts")
    public List<ProductModel> getUser(){
        return  productService.findAllProduct();
    }

    @GetMapping(value = "/getProductId")
    public ProductModel getUserId(@PathVariable long id){
        return productService.findById(id);
    }

    @PostMapping(value = "/addProduct")
    public  ProductModel addProduct(@RequestBody ProductModel Product){
        return  productService.addProduct(Product);
    }

    @DeleteMapping(value = "/deleteProduct")
    public ProductModel deleteProduct(long id){
        return productService.deleteById(id);
    }
}
