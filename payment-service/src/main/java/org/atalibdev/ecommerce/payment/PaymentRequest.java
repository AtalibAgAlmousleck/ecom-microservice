package org.atalibdev.ecommerce.payment;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
