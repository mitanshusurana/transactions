package com.suranagems.transaction.controller;

import com.suranagems.transaction.models.Balance;
import com.suranagems.transaction.models.BalancesResponse;
import com.suranagems.transaction.models.Transaction;
import com.suranagems.transaction.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        System.out.println("Received transaction: " + transaction);
        return transactionService.createTransaction(transaction);
    }

    @GetMapping()
    public List<Transaction> getTransactionsByDate(@RequestParam("date") String date) {
        return transactionService.getTransactionsByDate(date);
    }

    @GetMapping("/name")
    public List<Transaction> getTransactionsByName(@RequestParam("name") String name) {
        return transactionService.getTransactionsByName(name);
    }

    @GetMapping("/balances")
    public BalancesResponse getBalances() {
        Map<String, Balance> balanceMap = transactionService.calculateBalances();
        return new BalancesResponse(new ArrayList<>(balanceMap.values()));
    }

    @DeleteMapping()
    public void deleteTransaction(@RequestParam("id") String id){
        transactionService.deleteTransaction(id);
    }
}