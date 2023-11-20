package com.lithan.jumpstart.payload.request;

import com.lithan.jumpstart.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.math.BigDecimal;

@Setter @Getter @NoArgsConstructor
public class ProductRequest {
    private Long productId;
    private String productName;
    private String slug;
    private String description;
    private BigDecimal price;
    private BigDecimal oldPrice;
    private Long stock;
    private Double weight;
    private Long categoryId;
}
