package com.suranagems.transaction.models;

import java.util.List;

public class BalancesResponse {
    private List<Balance> balances;

    // Default constructor
    public BalancesResponse() {
    }

    public BalancesResponse(List<Balance> balances) {
        this.balances = balances;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }
}