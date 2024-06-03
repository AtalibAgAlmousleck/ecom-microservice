package org.atalibdev.ecommerce.order;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
