package net.mrabet.accountservice;

import net.mrabet.accountservice.entities.BankAccount;
import net.mrabet.accountservice.enums.AccountType;
import net.mrabet.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
        return args -> {
            BankAccount bankAccount1 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("Mad")
                    .solde(9862.0)
                    .creatAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(1L)
                    .build();
            BankAccount bankAccount2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("Mad")
                    .solde(12200.0)
                    .creatAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(2L)
                    .build();
            bankAccountRepository.save(bankAccount1);
            bankAccountRepository.save(bankAccount2);
        };
    }

}
