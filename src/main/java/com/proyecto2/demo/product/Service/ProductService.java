package com.proyecto2.demo.product.Service;

import com.proyecto2.demo.product.models.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> findAllProduct();
    ProductModel findById(long id);
    ProductModel addProduct(ProductModel productModel);
    ProductModel deleteById(long id);


}
