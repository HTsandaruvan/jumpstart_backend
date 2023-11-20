package com.lithan.jumpstart.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lithan.jumpstart.constraint.ERole;
import com.lithan.jumpstart.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

@Setter @Getter @NoArgsConstructor
public class CustomerDto {
    private Long userId;
    private String fullName;
    private String email;
    private Date registeredAt;
    private ERole role;
    private Boolean isActive;
}
