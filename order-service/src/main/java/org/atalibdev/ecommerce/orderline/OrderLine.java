package org.atalibdev.ecommerce.orderline;

/**
 * Created by Almousleck on May, 2024
 */
import jakarta.persistence.*;
import lombok.*;
import org.atalibdev.ecommerce.order.Order;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity @Builder @Table(name = "customer_line")
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;
}
