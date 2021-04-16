package com.yates.dao;

import com.yates.entity.Order;

import java.util.List;

public interface IOrderDao {
    void insertOrder(Order order);
    List<Order> queryOrderByUserId(String userId);
}
