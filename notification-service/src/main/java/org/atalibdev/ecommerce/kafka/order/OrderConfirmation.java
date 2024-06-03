package org.atalibdev.ecommerce.kafka.order;

import org.atalibdev.ecommerce.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Almousleck on May, 2024
 */
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
