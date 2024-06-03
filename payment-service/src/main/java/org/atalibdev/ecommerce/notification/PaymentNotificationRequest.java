package org.atalibdev.ecommerce.notification;

import org.atalibdev.ecommerce.payment.PaymentMethod;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
