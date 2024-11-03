package com.suranagems.transaction.service;


import com.suranagems.transaction.models.Balance;
import com.suranagems.transaction.models.Transaction;
import com.suranagems.transaction.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        System.out.println("Transaction date before saving: " + transaction.getDate());

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByDate(String date) {
        return transactionRepository.findByDate(date);
    }

    public List<Transaction> getTransactionsByName(String name) {
        return transactionRepository.findByledgerName(name);
    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }

    public Map<String, Balance> calculateBalances() {
        List<Transaction> transactions = transactionRepository.findAll();
        Map<String, Balance> balanceMap = new HashMap<>();

        for (Transaction transaction : transactions) {
            String ledgerName = transaction.getLedgerName();
            Balance balance = balanceMap.getOrDefault(ledgerName, new Balance(ledgerName));

            // Calculate metal balance
            if ("metal received".equals(transaction.getTransaction())) {
                balance.addMetal(transaction.getPure());
            } else if ("metal given".equals(transaction.getTransaction())) {
                balance.subtractMetal(transaction.getPure());
            }

            // Calculate cash balance
            if ("purchase".equals(transaction.getTransaction())) {
                balance.addCash(transaction.getAmount());
            } else if ("sales".equals(transaction.getTransaction())) {
                balance.subtractCash(transaction.getAmount());
            } else if ("cash given".equals(transaction.getTransaction())) {
                balance.subtractCash(transaction.getCash());
            } else if ("cash received".equals(transaction.getTransaction())) {
                balance.addCash(transaction.getCash());
            }

            balanceMap.put(ledgerName, balance);
        }

        return balanceMap;
    }
}