package com.lithan.jumpstart.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class CreateCategoryRequest {
    private String categoryName;
}
