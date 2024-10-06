

package com.proyecto2.demo.product.Dao;
import com.proyecto2.demo.product.models.ProductModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class productDaoImpl implements  ProductDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ProductModel> findAllProduct() {
        String query = "from ProductModel";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public ProductModel findById(long id) {
        return entityManager.find(ProductModel.class, id);
    }

    @Override
    public ProductModel addProduct(ProductModel productModel) {
        return entityManager.merge(productModel);
    }

    @Override
    public ProductModel deleteById(long id) {
        return null;
    }
}
