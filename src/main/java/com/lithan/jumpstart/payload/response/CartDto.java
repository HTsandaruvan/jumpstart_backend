package com.lithan.jumpstart.payload.response;

import com.lithan.jumpstart.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CartDto {
    private Long cartId;
    private Long userId;
    private int cartSize;
    private int itemNumbers;
    private BigDecimal total;
    private List<Item> items;
}
