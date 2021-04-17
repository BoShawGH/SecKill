package com.yates.vo;

public class CommonVo {
    public SecUserVo secUserVo;
    public MerchantVo merchantVo;
    public ProductVo productVo;
    public OrderVo orderVo;

    public OrderVo getOrderVo() {
        return orderVo;
    }

    public void setOrderVo(OrderVo orderVo) {
        this.orderVo = orderVo;
    }

    public ProductVo getProductVo() {
        return productVo;
    }

    public void setProductVo(ProductVo productVo) {
        this.productVo = productVo;
    }

    public MerchantVo getMerchantVo() {
        return merchantVo;
    }

    public void setMerchantVo(MerchantVo merchantVo) {
        this.merchantVo = merchantVo;
    }

    public SecUserVo getSecUserVo() {
        return secUserVo;
    }

    public void setSecUserVo(SecUserVo secUserVo) {
        this.secUserVo = secUserVo;
    }
}
