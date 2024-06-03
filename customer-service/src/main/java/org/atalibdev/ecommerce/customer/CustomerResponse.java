package org.atalibdev.ecommerce.customer;

/**
 * Created by Almousleck on May, 2024
 */
public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
