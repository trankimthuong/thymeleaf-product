package com.thymeleaf.service;

import com.thymeleaf.model.ProductModel;
import java.util.*;

public interface IProductService {
    List<ProductModel> findAll();

    boolean save(ProductModel productModel);

    ProductModel findById(Long id);

    boolean update(Long id, ProductModel productModel);

    ProductModel remove(Long id);
}
