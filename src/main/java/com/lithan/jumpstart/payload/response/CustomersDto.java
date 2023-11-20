package com.lithan.jumpstart.payload.response;

import com.lithan.jumpstart.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @NoArgsConstructor
public class CustomersDto {
    private int customerNumbers;
    private List<CustomerDto> customers;
}
