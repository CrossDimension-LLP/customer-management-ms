package com.octopus.customerManagement.config;

import com.octopus.customerManagement.businessLogic.implementation.Utility;
import com.octopus.customerManagement.businessLogic.interfaces.IUtility;
import com.octopus.customerManagement.service.implementation.CustomerGatewayService;
import com.octopus.customerManagement.service.interfaces.ICustomerGatewayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfiguration {
    @Bean
    public ICustomerGatewayService customerGatewayService() {
        return new CustomerGatewayService();
    }

    @Bean
    public IUtility utility() {
        return new Utility();
    }
}
