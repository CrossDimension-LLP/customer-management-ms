package com.octopus.customerManagement.repository.interfaces;

import com.octopus.customerManagement.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepository extends MongoRepository<Customer, String> {
}
