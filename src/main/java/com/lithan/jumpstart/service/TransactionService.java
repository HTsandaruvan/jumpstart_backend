package com.lithan.jumpstart.service;

import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.response.BaseResponse;

import java.math.BigDecimal;

public interface TransactionService {
    BaseResponse<?> createPayment(User user);
    BaseResponse<?> completePayment(User user, String token);
}
