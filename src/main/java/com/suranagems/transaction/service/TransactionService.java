package com.suranagems.transaction.service;


import com.suranagems.transaction.models.Transaction;
import com.suranagems.transaction.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByDate(String date) {
        return transactionRepository.findByDate(LocalDate.parse(date));
    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }
}