package com.lithan.jumpstart.service;

import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.response.BaseResponse;

public interface ProductSnapshotService {
    BaseResponse<?> showSnapshotDetailsBySlug(User user, String slug);
}
