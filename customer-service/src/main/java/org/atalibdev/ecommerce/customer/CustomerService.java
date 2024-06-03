package org.atalibdev.ecommerce.customer;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.atalibdev.ecommerce.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Almousleck on May, 2024
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest customerRequest) {
        var customer = this.customerRepository
                .save(customerMapper.toCustomer(customerRequest));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest customerRequest) {
        var customer = this.customerRepository.findById(customerRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Cannot update customer:: No customer found with the provided ID: %s".formatted(customerRequest.id())
                ));
        mergeCustomer(customer, customerRequest);
        this.customerRepository.save(customer);
    }

    public void mergeCustomer(Customer customer, CustomerRequest customerRequest) {
        if (StringUtils.isNotBlank(customerRequest.firstname()))
            customer.setFirstname(customerRequest.firstname());

//        if (StringUtils.isNotBlank(customerRequest.lastname()))
//            customer.setLastname(customerRequest.lastname());

        if (StringUtils.isNotBlank(customerRequest.email()))
            customer.setEmail(customerRequest.email());

        if (customerRequest.address() != null)
            customer.setAddress(customerRequest.address());
    }

    public List<CustomerResponse> findAllCustomers() {
        return  this.customerRepository.findAll()
                .stream()
                .map(this.customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public CustomerResponse findById(String id) {
        return this.customerRepository
                .findById(id)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer with the given id: %s was not found".formatted(id)
                ));
    }

    public boolean existsById(String id) {
        return this.customerRepository.findById(id)
                .isPresent();
    }

    public void deleteCustomer(String id) {
        this.customerRepository.deleteById(id);
    }
}
