package com.octopus.customerManagement.controllers;

import com.octopus.customerManagement.model.Customer;
import com.octopus.customerManagement.service.interfaces.ICustomerGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CustomerRestController {

    @Autowired
    private ICustomerGatewayService customerGatewayService;

    @PostMapping(value = "/customer")
    public Customer createEmployee(@RequestBody Customer customer) {
        return customerGatewayService.createCustomerProfile(customer);
    }
}
