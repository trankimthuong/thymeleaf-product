package com.thymeleaf.service.impl;

import com.thymeleaf.model.ProductModel;
import com.thymeleaf.service.IProductService;

import java.util.*;

public class ProductService implements IProductService {
    private static List<ProductModel> products = new ArrayList<>();
    static {
        ProductModel product1 = new ProductModel(1L, "kem đánh răng", "P/S");
        ProductModel product2 = new ProductModel(2L, "dầu gội", "Xmen");
        ProductModel product3 = new ProductModel(3L, "xà phòng tắm", "lifeboy");
        ProductModel product4 = new ProductModel(4L, "giày", "nike");
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }

    @Override
    public List<ProductModel> findAll() {
        return products;
    }

    @Override
    public boolean save(ProductModel productModel) {
        products.add(productModel);
        return true;
    }

    @Override
    public ProductModel findById(Long id) {
        return products.get(Math.toIntExact(id));
    }

    @Override
    public boolean update(Long id, ProductModel productModel) {

        return false;
    }

    @Override
    public ProductModel remove(Long id) {
        return null;
    }
}
