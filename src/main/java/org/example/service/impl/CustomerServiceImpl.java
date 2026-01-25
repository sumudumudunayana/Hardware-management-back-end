package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDto;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<CustomerDto> getAll() {
        List<CustomerDto> CustomerArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            CustomerArrayList.add(mapper.map(entity, CustomerDto.class));
        });
        return CustomerArrayList;
    }

    @Override
    public void addCustomer(CustomerDto customerDto) {
        System.out.println(customerDto);
        repository.save(mapper.map(customerDto, CustomerEntity.class));
    }

    @Override
    public void deleteCustomerById(Integer id){
        repository.deleteById(id);
    }

    @Override
    public CustomerDto searchCustomerById(Integer id) {
        return mapper.map(repository.findById(id),CustomerDto.class);
    }

    @Override
    public void updateCustomerById(CustomerDto customerDto) {
        repository.save(mapper.map(customerDto, CustomerEntity.class));
    }
}
