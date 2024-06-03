package org.atalibdev.ecommerce.payment;

import org.springframework.stereotype.Service;

/**
 * Created by Almousleck on May, 2024
 */
@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest request) {
        if (request == null) {
            return null;
        }
        return Payment.builder()
                .id(request.id())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .orderId(request.orderId())
                .build();
    }
}
