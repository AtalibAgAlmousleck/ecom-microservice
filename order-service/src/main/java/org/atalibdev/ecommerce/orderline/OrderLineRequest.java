package org.atalibdev.ecommerce.orderline;

/**
 * Created by Almousleck on May, 2024
 */
public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        double quantity
) {
}
