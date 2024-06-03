package org.atalibdev.ecommerce.kafka.payment;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
