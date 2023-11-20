package com.lithan.jumpstart.utils;

import com.lithan.jumpstart.constraint.EItemStatus;
import com.lithan.jumpstart.entity.*;
import com.lithan.jumpstart.exception.CartNotFoundException;
import com.lithan.jumpstart.exception.OutOfCartMaxTotalException;
import com.lithan.jumpstart.exception.OutOfProductStockException;
import com.lithan.jumpstart.exception.ProductNotFoundException;
import com.lithan.jumpstart.payload.request.ItemRequest;
import com.lithan.jumpstart.payload.response.BaseResponse;
import com.lithan.jumpstart.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.lithan.jumpstart.service.impl.CartServiceImpl.maxAmount;

public class OrderUtils extends ServiceUtils {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductSnapshotRepository productSnapshotRepository;

    protected void checkCartTotal(BigDecimal tempItemTotal, BigDecimal cartTotal) {
        BigDecimal cartTotalValidation = tempItemTotal.add(cartTotal);
        if (cartTotalValidation.compareTo(maxAmount) > 0) {
            throw new OutOfCartMaxTotalException("Your cart total is greater than $9,999,999.99");
        }
    }

    protected void checkProductStockWithCartItem(ItemRequest itemRequest, String message) {
        Product product = productRepository.findByProductId(itemRequest.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("product not found"));
        Item itemOfProduct = itemRepository.findByProductAndStatus(product, EItemStatus.IN_CART);

        int quantityRequest = itemRequest.getQuantity();
        Long productStock = product.getStock();

        if (itemOfProduct != null) {
            int quantityOfCartItem = itemOfProduct.getQuantity();
            int checkedQuantity = 0;
            if (itemRequest.getRequestFrom() != null && itemRequest.getRequestFrom().equals("FROM_CART")) {
                checkedQuantity = quantityRequest;
            } else {
                checkedQuantity = quantityOfCartItem + quantityRequest;
            }
            if (checkedQuantity > productStock) {
                throw new OutOfProductStockException(message);
            }
        } else {
            if (quantityRequest > productStock) {
                throw new OutOfProductStockException(message);
            }
        }
    }

    protected BigDecimal checkTotal(List<Item> items) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (Item item : items) {
            total = total.add(item.getItemPriceTotal());
        }

        if (total.compareTo(maxAmount) > 0) {
            throw new OutOfCartMaxTotalException("Your cart total is greater than $9,999,999.99");
        }

        return total;
    }
}
