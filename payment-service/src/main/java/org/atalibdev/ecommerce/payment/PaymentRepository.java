package org.atalibdev.ecommerce.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Almousleck on May, 2024
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
