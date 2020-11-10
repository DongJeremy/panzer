package org.cloud.panzer.serivce.impl;

import org.cloud.panzer.domain.Product;
import org.cloud.panzer.serivce.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProductById(String productId) {
        return null;
    }
}
