package net.mrabet.customer.repository;

import net.mrabet.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Long>{
}
