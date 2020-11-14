package org.cloud.panzer.controller;

import org.cloud.panzer.domain.Product;
import org.cloud.panzer.serivce.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

//    @Resource
//    private ProductService productService;
//
//    /**
//     * 获取产品列表
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/list")
//    public ResultBean<List<Product>> products() {
//        List<Product> pList = productService.getProducts();
//        return new ResultBean<>(200, pList);
//    }
}
