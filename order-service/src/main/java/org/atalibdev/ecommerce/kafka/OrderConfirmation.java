package org.atalibdev.ecommerce.kafka;

import org.atalibdev.ecommerce.customer.CustomerResponse;
import org.atalibdev.ecommerce.order.PaymentMethod;
import org.atalibdev.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Almousleck on May, 2024
 */
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
