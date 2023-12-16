package org.lerob.customerservice;

import org.lerob.customerservice.config.GlobalConfig;
import org.lerob.customerservice.entities.Customer;
import org.lerob.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
      return args -> {
          Customer customer1 = new Customer();
              customer1.setFirstName("firstname1");
              customer1.setLastName("lastname1");
              customer1.setEmail("customer1@demo.com");

          Customer customer2 = new Customer();
              customer2.setFirstName("firstname2");
              customer2.setLastName("lastname2");
              customer2.setEmail("customer2@demo.com");

          List<Customer> customerList = List.of(customer1,customer2);

          customerRepository.saveAll(customerList);
      };
    }

}
