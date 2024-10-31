package com.suranagems.transaction.repo;

import com.suranagems.transaction.models.CreateCustomer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LedgerRepository extends MongoRepository<CreateCustomer, String> {
    @Query(value = "{}", fields = "{ 'customerName' : 1, '_id' : 0 }")
    List<CreateCustomer > findLedgerNameBy();
}
