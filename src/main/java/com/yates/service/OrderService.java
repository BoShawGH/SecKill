package com.yates.service;

import com.yates.dao.IOrderDao;
import com.yates.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public IOrderDao iOrderDao;
    public void insertOrder(Order order){
        iOrderDao.insertOrder(order);
    }
}
