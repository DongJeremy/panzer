package org.cloud.panzer.serivce;

import org.cloud.panzer.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 获取所有产品列表
     * @return
     */
    List<Product> getProducts();

    /**
     * 根据产品ID查询产品详情
     * @param productId
     * @return
     */
    Product getProductById(String productId);
}
