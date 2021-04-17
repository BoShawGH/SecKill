package com.yates.service;

import com.yates.dao.IOrderDao;
import com.yates.entity.Order;
import com.yates.vo.CommonVo;
import com.yates.vo.OrderVo;
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

    public void cancelOrder(String transSerial) {
        iOrderDao.cancelOrder(transSerial);
    }

    public Order queryOrderByTransSerial(String transSerial) {
        return iOrderDao.queryOrderByTransSerial(transSerial);
    }

    public void updateOrder(CommonVo commonVo) {
        iOrderDao.updateOrder(commonVo);
    }

    public List<Order> merchantQuery(String merchantId) {
        return iOrderDao.merchantQuery(merchantId);
    }

    public void applyRefund(String transSerial, String payState) {
        CommonVo commonVo = new CommonVo();
        OrderVo orderVo = new OrderVo();
        orderVo.setPayState(payState);
        orderVo.setTransSerial(transSerial);
        commonVo.setOrderVo(orderVo);
        updateOrderState(commonVo);

    }

    private void updateOrderState(CommonVo commonVo) {
        iOrderDao.updateOrderState(commonVo);
    }
}
