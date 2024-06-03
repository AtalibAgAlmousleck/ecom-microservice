package org.atalibdev.ecommerce.product;

import java.math.BigDecimal;

/**
 * Created by Almousleck on May, 2024
 */
public record ProductResponse(
        Integer id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription) {
}
