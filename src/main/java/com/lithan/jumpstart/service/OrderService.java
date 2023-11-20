package com.lithan.jumpstart.service;

import com.lithan.jumpstart.constraint.EOrderStatus;
import com.lithan.jumpstart.entity.Item;
import com.lithan.jumpstart.entity.Order;
import com.lithan.jumpstart.entity.ProductSnapshot;
import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.response.BaseResponse;

import java.util.List;

public interface OrderService {
    BaseResponse<?> saveNewOrder(User user);
    void convertCartItemsToSnapshots(Order order, List<Item> items);
    BaseResponse<?> getAllOrders(User user, String status, String orderBy);
    BaseResponse<?> getMyOrders(User user, String status, String orderBy);
    BaseResponse<?> completeOrder(User user, Long orderId);
    BaseResponse<?> cancelOrder(User user, Long orderId);
}
