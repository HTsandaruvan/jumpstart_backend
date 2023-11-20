package com.lithan.jumpstart.service;

import com.lithan.jumpstart.constraint.EGender;
import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.request.UpdateUserRequest;
import com.lithan.jumpstart.payload.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UserProfileService {
    EGender getEnumGender(String gender);
    BaseResponse<?> updateProfile(User user, UpdateUserRequest updateUserRequest);
    BaseResponse<?> updateProfilePicture(User user, MultipartFile profilePicture);

    boolean isCurrentUserOrAdmin(String email);
}
