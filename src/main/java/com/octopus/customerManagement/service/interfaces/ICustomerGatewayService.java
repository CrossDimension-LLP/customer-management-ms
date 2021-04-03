package com.octopus.customerManagement.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.octopus.customerManagement.model.Customer;
import com.octopus.customerManagement.model.PatchElement;
import org.json.JSONObject;

import java.util.Optional;

public interface ICustomerGatewayService {

    Customer createCustomerProfile(Customer customer);
    Optional<Customer> getCustomerById(String id);
    Optional<Customer> updateCustomerDetails(String id, PatchElement patchElement) throws JsonProcessingException;
}
