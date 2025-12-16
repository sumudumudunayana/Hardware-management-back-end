package org.example.service;

import org.example.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAll();

    void addCustomer(CustomerDto customerDto);

    void deleteCustomerById(Integer id);

    CustomerDto searchCustomerById(Integer id);

    void updateCustomerById(CustomerDto customerDto);
}
