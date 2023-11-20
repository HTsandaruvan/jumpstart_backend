package com.lithan.jumpstart.service;

import com.lithan.jumpstart.entity.Item;
import com.lithan.jumpstart.payload.response.BaseResponse;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    BigDecimal checkTotal(List<Item> items);
    BaseResponse<?> addProductToCart(String currentUserEmail, Long productId);
    BaseResponse<?> getMyCart(String email);
}
