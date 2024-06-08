package net.mrabet.accountservice.web;

import net.mrabet.accountservice.clients.CustomerRestClient;
import net.mrabet.accountservice.entities.BankAccount;
import net.mrabet.accountservice.model.Customer;
import net.mrabet.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {
   private final BankAccountRepository bankAccountRepository;
   private final CustomerRestClient customerRestClient;
    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRepository;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAccounts()
    {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccountById(@PathVariable String id) {
        BankAccount bankAccount=bankAccountRepository.findById(id).get();
        Customer customer =customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }


}
