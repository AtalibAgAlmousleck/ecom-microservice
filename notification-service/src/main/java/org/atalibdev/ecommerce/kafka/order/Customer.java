package org.atalibdev.ecommerce.kafka.order;

/**
 * Created by Almousleck on May, 2024
 */
public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
