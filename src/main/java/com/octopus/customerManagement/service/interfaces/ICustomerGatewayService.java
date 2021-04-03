package com.octopus.customerManagement.service.interfaces;

import com.octopus.customerManagement.model.Customer;

public interface ICustomerGatewayService {

    Customer createCustomerProfile(Customer customer);
}
