package com.yates.common;

import com.yates.entity.Merchant;
import com.yates.entity.Product;
import com.yates.entity.ProductDetail;
import com.yates.entity.SecUser;
import com.yates.service.MerchantService;
import com.yates.service.ProductService;
import com.yates.service.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class CommonFunc {

    @Autowired
    public static SecUserService secUserService;
    @Autowired
    public static MerchantService merchantService;
    @Autowired
    public static ProductService productService;

    public static boolean objectExist(Object o){
        String[] types = new String[]{"SecUser", "Merchant", "Product", "ProductDetail"};
        Class cl = o.getClass();
        if(!Arrays.asList(types).contains(cl.toGenericString()))
            return false;
        else if(cl == SecUser.class) {
            return secUserService.queryUserById(((SecUser) o).getUserId()) != null;
        }
        else if(cl == Merchant.class){
            return merchantService.queryMerchantById(((Merchant)o).getMerchantId()) != null;
        }
        else if(cl == Product.class){
            return productService.queryProductById(((Product)o).getMerchantId())!=null;
        }
        else
            return false;
    }
}
