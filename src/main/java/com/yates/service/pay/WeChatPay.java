package com.yates.service.pay;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WeChatPay implements OrderPay{
    @Override
    public int payWithOrder(BigDecimal payAmount, String transSerial) {
        return 1;
    }
}
