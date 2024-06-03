package org.atalibdev.ecommerce.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Almousleck on May, 2024
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Customer {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
