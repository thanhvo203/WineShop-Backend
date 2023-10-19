package com.example.wines_shop.repository;

import com.example.wines_shop.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select * from customer where customer.id_account =:idAccount", nativeQuery = true)
    Customer getCustomerByIdAccount(@Param("idAccount") Long idAccount);
}
