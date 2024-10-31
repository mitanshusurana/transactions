package com.suranagems.transaction.controller;

import com.suranagems.transaction.models.Transaction;
import com.suranagems.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping()
    public List<Transaction> getTransactionsByDate(@RequestParam("date") String date) {
        return transactionService.getTransactionsByDate(date);
    }

    @DeleteMapping()
    public void deleteTransaction(@RequestParam("id") String id){
        transactionService.deleteTransaction(id);
    }
}