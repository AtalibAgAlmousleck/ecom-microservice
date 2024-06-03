package org.atalibdev.ecommerce.notification;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Almousleck on May, 2024
 */
@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
}
