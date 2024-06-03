package org.atalibdev.ecommerce.product;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record PurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
