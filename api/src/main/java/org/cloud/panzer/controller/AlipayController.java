package org.cloud.panzer.controller;

import org.cloud.panzer.serivce.OrdersService;
import org.cloud.panzer.serivce.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/alipay")
public class AlipayController {
    final static Logger log = LoggerFactory.getLogger(AlipayController.class);

    @Resource
    private ProductService productService;

    @Resource
    private OrdersService orderService;

//    @Resource
//    private Sid sid;

    /**
     * 获取产品列表
     * @return
     * @throws Exception
     */
//    @GetMapping(value = "/products")
//    public ModelAndView products() throws Exception {
//        List<Product> pList = productService.getProducts();
//        ModelAndView mv = new ModelAndView("products");
//        mv.addObject("pList", pList);
//        return mv;
//    }



}
