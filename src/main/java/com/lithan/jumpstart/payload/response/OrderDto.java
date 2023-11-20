package com.lithan.jumpstart.payload.response;

import com.lithan.jumpstart.entity.Order;
import com.lithan.jumpstart.entity.ProductSnapshot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter @Getter @NoArgsConstructor
public class OrderDto {
    private String filter;
    private String orderBy;
    private int orderNumbers;
    private List<Order> orders;
}
