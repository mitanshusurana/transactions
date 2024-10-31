package com.suranagems.transaction.controller;

import com.suranagems.transaction.models.CreateCustomer;
import com.suranagems.transaction.service.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Ledgers")
public class LedgersController {

    @Autowired
    private LedgerService ledgerService;

    @PostMapping
    public CreateCustomer createCustomer(@RequestBody CreateCustomer createCustomer) {
        return ledgerService.createCustomer(createCustomer);
    }

    @GetMapping
    public List<String> createCustomer() {
        return ledgerService.getCustomers();
    }

}