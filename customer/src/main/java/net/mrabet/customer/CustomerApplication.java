package net.mrabet.customer;

import net.mrabet.customer.config.GloblaConfig;
import net.mrabet.customer.entities.Customer;
import net.mrabet.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GloblaConfig.class)
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder()
                            .firstName("Hassen")
                            .lastName("Elhoumi")
                            .email("hassen@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Mouhamed")
                            .lastName("Elhannoui")
                            .email("mouhamed@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customers);
        };
    }


}
