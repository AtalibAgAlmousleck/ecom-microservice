package org.atalibdev.ecommerce.payment;

import lombok.RequiredArgsConstructor;
import org.atalibdev.ecommerce.notification.NotificationProducer;
import org.atalibdev.ecommerce.notification.PaymentNotificationRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Almousleck on May, 2024
 */
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = this.repository.save(this.mapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
