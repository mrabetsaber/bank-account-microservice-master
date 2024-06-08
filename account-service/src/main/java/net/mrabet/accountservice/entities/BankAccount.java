package net.mrabet.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.mrabet.accountservice.enums.AccountType;
import net.mrabet.accountservice.model.Customer;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class BankAccount   {
    @Id
    private String accountId;
    private Double solde;
    private LocalDate creatAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
