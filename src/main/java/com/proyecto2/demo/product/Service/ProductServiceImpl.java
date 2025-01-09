package com.proyecto2.demo.product.Service;

import com.proyecto2.demo.product.Dao.ProductDao;
import com.proyecto2.demo.product.models.ProductModel;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Override
    public List<ProductModel> findAllProduct() {
        return productDao.findAllProduct();
    }

    @Override
    public ProductModel findById(long id) {
        return productDao.findById(id);
    }

    @Override
    public ProductModel addProduct(ProductModel productModel) {
        return null;
    }

    @Override
    public ProductModel deleteById(long id) {
        return null;
    }
}
