package com.lithan.jumpstart.service.impl;

import com.lithan.jumpstart.constraint.EOrderStatus;
import com.lithan.jumpstart.constraint.ERole;
import com.lithan.jumpstart.entity.Order;
import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.response.BaseResponse;
import com.lithan.jumpstart.payload.response.StatsDto;
import com.lithan.jumpstart.repository.CategoryRepository;
import com.lithan.jumpstart.repository.OrderRepository;
import com.lithan.jumpstart.repository.ProductRepository;
import com.lithan.jumpstart.repository.UserRepository;
import com.lithan.jumpstart.service.StatisticService;
import com.lithan.jumpstart.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StatisticServiceImpl extends ServiceUtils implements StatisticService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public BaseResponse<?> getAllStats(User user) {
        try {
            if (!isAdmin(user.getEmail())) {
                return BaseResponse.forbidden();
            }

            StatsDto result = new StatsDto();
            BigDecimal revenue = getRevenue();
            int customerNumbers = getCustomerNumbers();
            int orderNumbers = getOrderNumbers();
            int productNumbers = getProductNumbers();
            int categoryNumbers = getCategoryNumbers();

            result.setRevenue(revenue);
            result.setCustomerNumbers(customerNumbers);
            result.setOrderNumbers(orderNumbers);
            result.setProductNumbers(productNumbers);
            result.setCategoryNumbers(categoryNumbers);

            return BaseResponse.ok(result);
        } catch (Exception e) {
            return BaseResponse.badRequest(e.getMessage());
        }
    }

    @Override
    public BigDecimal getRevenue() {
        List<Order> orders = orderRepository.findAllByStatus(EOrderStatus.COMPLETED);
        BigDecimal revenue = new BigDecimal(0);
        for (Order order : orders) {
            revenue = revenue.add(order.getTotal());
        }
        return revenue;
    }

    @Override
    public int getCustomerNumbers() {
        return userRepository.findAllByRole(ERole.ROLE_USER).size();
    }

    @Override
    public int getOrderNumbers() {
        return orderRepository.findAll().size();
    }

    @Override
    public int getProductNumbers() {
        return productRepository.findAll().size();
    }

    @Override
    public int getCategoryNumbers() {
        return categoryRepository.findAll().size();
    }
}
