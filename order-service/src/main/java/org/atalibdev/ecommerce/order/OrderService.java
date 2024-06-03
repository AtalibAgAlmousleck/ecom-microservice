package org.atalibdev.ecommerce.order;

import lombok.RequiredArgsConstructor;
import org.atalibdev.ecommerce.customer.CustomerClient;
import org.atalibdev.ecommerce.exception.BusinessException;
import org.atalibdev.ecommerce.kafka.OrderConfirmation;
import org.atalibdev.ecommerce.kafka.OrderProducer;
import org.atalibdev.ecommerce.orderline.OrderLineRequest;
import org.atalibdev.ecommerce.orderline.OrderLineService;
import org.atalibdev.ecommerce.payment.PaymentClient;
import org.atalibdev.ecommerce.payment.PaymentRequest;
import org.atalibdev.ecommerce.product.ProductClient;
import org.atalibdev.ecommerce.product.PurchaseRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Almousleck on May, 2024
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Transactional
    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient
                .findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));
        var purchaseProducts = productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService
                    .saveOrderLine(
                            new OrderLineRequest(
                                    null,
                                    order.getId(),
                                    purchaseRequest.productId(),
                                    purchaseRequest.quantity()));
        }
        //todo: start payment process
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        //todo: send the order confirmation --> notification service (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchaseProducts));

        return order.getId();
    }

    public List<OrderResponse> findAllOrders() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(this.mapper::fromOrder)
                .orElseThrow(() ->
                        new BusinessException("No order found with the provided ID"
                                .formatted(id)));
    }
}
