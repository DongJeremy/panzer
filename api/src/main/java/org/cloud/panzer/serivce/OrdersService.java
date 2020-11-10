package org.cloud.panzer.serivce;

import org.cloud.panzer.domain.Orders;

public interface OrdersService {

    /**
     * 新增订单
     *
     * @param order
     */
    void saveOrder(Orders order);

    /**
     * @Title: OrdersService.java
     * @Package com.sihai.service
     * @Description: 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     * @author sihai
     * @date 2017年8月23日 下午9:04:35
     * @version V1.0
     */
    void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount);

    /**
     * 获取订单
     *
     * @param orderId
     * @return
     */
    Orders getOrderById(String orderId);

}
