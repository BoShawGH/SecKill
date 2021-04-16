package com.yates.service;

import com.yates.dao.IOrderDao;
import com.yates.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public IOrderDao iOrderDao;

    public void insertOrder(Order order){
        iOrderDao.insertOrder(order);
    }

    public List<Order> queryOrderByUserId(String userId){
        return iOrderDao.queryOrderByUserId(userId);
    }
}
