package com.lithan.jumpstart.service.impl;

import com.lithan.jumpstart.entity.Product;
import com.lithan.jumpstart.entity.ProductSnapshot;
import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.exception.ProductNotFoundException;
import com.lithan.jumpstart.exception.RefusedActionException;
import com.lithan.jumpstart.payload.response.BaseResponse;
import com.lithan.jumpstart.repository.ProductSnapshotRepository;
import com.lithan.jumpstart.service.ProductSnapshotService;
import com.lithan.jumpstart.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSnapshotServiceImpl extends OrderUtils implements ProductSnapshotService {
    @Autowired
    private ProductSnapshotRepository productSnapshotRepository;

    @Override
    public BaseResponse<?> showSnapshotDetailsBySlug(User user, String slug) {
        try {
            ProductSnapshot detailedSnapshot = productSnapshotRepository.findBySlug(slug);
            if (detailedSnapshot == null) {
                throw new ProductNotFoundException("Snapshot not found.");
            }
            if (user != detailedSnapshot.getOrder().getUser() && !isAdmin(user.getEmail())) {
                throw new RefusedActionException("Access denied.");
            }
            return BaseResponse.ok(detailedSnapshot);
        } catch (ProductNotFoundException e) {
            return BaseResponse.notFound(e.getMessage());
        }
    }
}
