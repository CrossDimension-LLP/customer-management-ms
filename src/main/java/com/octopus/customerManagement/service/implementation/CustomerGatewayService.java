package com.octopus.customerManagement.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.octopus.customerManagement.businessLogic.interfaces.IPatchUtility;
import com.octopus.customerManagement.businessLogic.interfaces.IUtility;
import com.octopus.customerManagement.config.CustomerManagementConstants;
import com.octopus.customerManagement.model.Customer;
import com.octopus.customerManagement.model.PatchElement;
import com.octopus.customerManagement.repository.interfaces.ICustomerRepository;
import com.octopus.customerManagement.service.interfaces.ICustomerGatewayService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.Optional;

public class CustomerGatewayService implements ICustomerGatewayService {

    @Autowired
    private IUtility utilityLogic;
    @Autowired
    private IPatchUtility patchUtility;
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer createCustomerProfile(Customer customer) {
        customer.setId("Customer_"+utilityLogic.IdGenerator());
        customer.setFullName(customer.getFirstName() + " " + customer.getLastName());
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> updateCustomerDetails(String id, PatchElement patchElement) throws JsonProcessingException {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer customerRes = new Customer();
        Gson gson = new Gson();
        ObjectMapper o = new ObjectMapper();
        JSONObject result = new JSONObject();

        String[] keys = patchUtility.extractKeys(patchElement.getPath());
        String jsonCustomerString = gson.toJson(customer);
        JSONObject requestPatch = new JSONObject(jsonCustomerString);
        if (patchElement.getOp().equalsIgnoreCase(CustomerManagementConstants.REMOVE)) {
            result = patchUtility.removeValue(requestPatch, keys).getJSONObject("value");
        } else {
            result = patchUtility.addValue(patchElement.getValue(), requestPatch, keys).getJSONObject("value");
        }
        customerRes = o.readValue(result.toString(), Customer.class);
        customerRepository.save(customerRes);
        customer = Optional.of(customerRes);
        return customer;
    }
}
