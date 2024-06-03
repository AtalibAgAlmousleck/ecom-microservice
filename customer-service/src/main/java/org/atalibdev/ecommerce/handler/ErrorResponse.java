package org.atalibdev.ecommerce.handler;

import java.util.Map;

/**
 * Created by Almousleck on May, 2024
 */
public record ErrorResponse(
        Map<String, String> errors) {
}
