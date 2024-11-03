package com.suranagems.transaction.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "transactions")
@Data
public class Transaction {
    @Id
    private String id;
    private String date;
    private String transaction;
    private String ledgerName;
    private String stockName;
    private double netWeight;
    private double touch;
    private double rate;
    private double cash;
    private double pure;
    private double amount;
    private String comments;

    // Getters and Setters
}
