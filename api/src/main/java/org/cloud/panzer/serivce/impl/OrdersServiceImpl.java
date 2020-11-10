package org.cloud.panzer.serivce.impl;

import org.cloud.panzer.domain.Orders;
import org.cloud.panzer.serivce.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Override
    public void saveOrder(Orders order) {

    }

    @Override
    public void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount) {

    }

    @Override
    public Orders getOrderById(String orderId) {
        return null;
    }
}
