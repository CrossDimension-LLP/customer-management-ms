package com.octopus.customerManagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.octopus.customerManagement.model.Customer;
import com.octopus.customerManagement.model.PatchElement;
import com.octopus.customerManagement.service.interfaces.ICustomerGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class CustomerRestController {

    @Autowired
    private ICustomerGatewayService customerGatewayService;

    @PostMapping(value = "/customer")
    public Customer createEmployee(@RequestBody Customer customer) {
        return customerGatewayService.createCustomerProfile(customer);
    }
    @GetMapping(value= "/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") String id) {
        return customerGatewayService.getCustomerById(id);
    }

    @PatchMapping(value = "/customer/{id}")
    public Optional<Customer> updateCustomerDetails(@PathVariable("id") String id, @RequestBody PatchElement patchElement) throws JsonProcessingException {
        return customerGatewayService.updateCustomerDetails(id, patchElement);
    }
}
