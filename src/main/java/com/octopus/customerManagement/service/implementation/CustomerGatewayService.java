package com.octopus.customerManagement.service.implementation;

import com.octopus.customerManagement.businessLogic.interfaces.IUtility;
import com.octopus.customerManagement.model.Customer;
import com.octopus.customerManagement.repository.interfaces.ICustomerRepository;
import com.octopus.customerManagement.service.interfaces.ICustomerGatewayService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerGatewayService implements ICustomerGatewayService {

    @Autowired
    private IUtility utilityLogic;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer createCustomerProfile(Customer customer) {
        customer.setId("Customer_"+utilityLogic.IdGenerator());
        customer.setFullName(customer.getFirstName() + " " + customer.getLastName());
        customerRepository.save(customer);
        return customer;
    }
}
