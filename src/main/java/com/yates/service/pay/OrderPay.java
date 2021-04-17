package com.yates.service.pay;

import java.math.BigDecimal;

public interface OrderPay {
    /**
     *
     * @param payAmount
     * @param transSerial
     * @return 1:支付成功，0：支付失败
     */
    int payWithOrder(BigDecimal payAmount, String transSerial);
}
