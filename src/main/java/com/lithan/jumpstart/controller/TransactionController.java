package com.lithan.jumpstart.controller;

import com.paypal.core.PayPalHttpClient;
import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.response.BaseResponse;
import com.lithan.jumpstart.service.TransactionService;
import com.lithan.jumpstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/paypal")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PayPalHttpClient payPalHttpClient;

    @Autowired
    private UserService userService;

    @GetMapping("/init")
    public ResponseEntity<?> createPayment() {
//        BigDecimal sum = new BigDecimal(sumStr);
        User user = userService.getCurrentUser();

        BaseResponse<?> response = transactionService.createPayment(user);
        if (response.getCode() == 200) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/capture")
    public ResponseEntity<?> completePayment(@RequestParam("token") String token) {
        User user = userService.getCurrentUser();
        BaseResponse<?> response = transactionService.completePayment(user, token);
        if (response.getCode() == 200) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
