package com.lithan.jumpstart.payload.response;

import com.lithan.jumpstart.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @NoArgsConstructor
public class ProductSearchResultDto {
    private String categorySlug;
    private String query;
    private int resultSize;
    private List<Product> searchResults;
}
