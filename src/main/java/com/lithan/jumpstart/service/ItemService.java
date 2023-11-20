package com.lithan.jumpstart.service;

import com.lithan.jumpstart.payload.request.ItemRequest;
import com.lithan.jumpstart.payload.response.BaseResponse;

import java.math.BigDecimal;

public interface ItemService {
    BigDecimal checkItemTotal(ItemRequest itemRequest);
    BaseResponse<?> saveCartItem(String email, ItemRequest itemRequest);
    BaseResponse<?> deleteCartItemById(String email, Long cartItemId);
}
