package org.atalibdev.ecommerce.category;

/**
 * Created by Almousleck on May, 2024
 */
import jakarta.persistence.*;
import lombok.*;
import org.atalibdev.ecommerce.product.Product;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
