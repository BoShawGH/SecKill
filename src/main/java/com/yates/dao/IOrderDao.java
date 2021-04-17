package com.yates.dao;

import com.yates.entity.Order;
import com.yates.vo.CommonVo;

import java.util.List;

public interface IOrderDao {
    void insertOrder(Order order);
    List<Order> queryOrderByUserId(String userId);

    void cancelOrder(String transSerial);

    Order queryOrderByTransSerial(String transSerial);

    void updateOrder(CommonVo commonVo);

    List<Order> merchantQuery(String merchantId);

    void updateOrderState(CommonVo commonVo);
}
