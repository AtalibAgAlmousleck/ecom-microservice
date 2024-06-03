package org.atalibdev.ecommerce.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Almousleck on May, 2024
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
