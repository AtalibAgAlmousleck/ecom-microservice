package org.atalibdev.ecommerce.kafka.order;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
