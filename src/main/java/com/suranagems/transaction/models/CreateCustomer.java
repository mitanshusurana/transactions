package com.suranagems.transaction.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Data
public class CreateCustomer {
    @Id
    private String custId;
    private String customerName;
    private double cashBalance;
    private double stockBalance;
}
