package com.suranagems.transaction.service;

import com.suranagems.transaction.models.CreateCustomer;
import com.suranagems.transaction.repo.LedgerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LedgerService {
    private static final Logger log = LoggerFactory.getLogger(LedgerService.class);
    @Autowired
    private LedgerRepository ledgerRepository;

    @Transactional
    public CreateCustomer createCustomer(CreateCustomer createCustomer) {
        return ledgerRepository.save(createCustomer);
    }

    public List<String> getCustomers() {
        log.info("getCustmers triggered");
        List<CreateCustomer> customers=ledgerRepository.findLedgerNameBy();
        return customers.stream()
                .map(CreateCustomer::getCustomerName) // Extract ledgerName
                .collect(Collectors.toList());
    }


}
