package org.atalibdev.ecommerce.customer;

/**
 * Created by Almousleck on May, 2024
 */
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
