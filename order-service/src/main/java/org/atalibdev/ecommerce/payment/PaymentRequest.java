package org.atalibdev.ecommerce.payment;

import org.atalibdev.ecommerce.customer.CustomerResponse;
import org.atalibdev.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
