package com.lithan.jumpstart.service;

import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.response.BaseResponse;

import java.math.BigDecimal;

public interface StatisticService {
    BaseResponse<?> getAllStats(User user);
    BigDecimal getRevenue();
    int getCustomerNumbers();
    int getOrderNumbers();
    int getProductNumbers();
    int getCategoryNumbers();
}
