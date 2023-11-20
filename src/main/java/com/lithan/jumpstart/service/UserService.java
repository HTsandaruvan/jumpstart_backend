package com.lithan.jumpstart.service;

import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.request.UpdatePasswordRequest;
import com.lithan.jumpstart.payload.request.UserRegisterRequest;
import com.lithan.jumpstart.payload.response.BaseResponse;
import org.springframework.security.core.context.SecurityContextHolder;

public interface UserService {
    BaseResponse<?> saveUser(UserRegisterRequest userRegisterRequest);
    User getCurrentUser();
    Boolean isActive(String email);
    BaseResponse<?> activateUser(String uuid);
    BaseResponse<?> findAccountByUuid(String uuid);
    BaseResponse<?> updateUuidResetPassword(String email);
    BaseResponse<?> updatePassword(UpdatePasswordRequest updatePasswordRequest);
    BaseResponse<?> showAllUsers(User user);
}
