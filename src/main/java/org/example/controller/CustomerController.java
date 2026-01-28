package org.example.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.CustomerDto;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class CustomerController {
    final CustomerService service;

    @GetMapping("/get-all")
    public List<CustomerDto> getCustomer() {
        return service.getAll();
    }

    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody CustomerDto customerDto){
        log.info("updated-> {}",customerDto);
        service.addCustomer(customerDto);
    }

    @GetMapping("/search-by-id/{id}")
    public CustomerDto getddCustomerById(@PathVariable Integer id){
        return service.searchCustomerById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteddCustomerById(@PathVariable Integer id){
        service.deleteCustomerById(id);
    }

    @PutMapping("/update-customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateddCustomerById(@RequestBody CustomerDto customerDto){
        service.updateCustomerById(customerDto);
    }
}
