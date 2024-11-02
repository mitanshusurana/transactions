package com.suranagems.transaction.repo;


import com.suranagems.transaction.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findByDate(LocalDate date);
    List<Transaction> findByledgerName(String name);
}