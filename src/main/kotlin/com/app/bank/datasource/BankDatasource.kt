package com.app.bank.datasource

import com.app.bank.models.Bank

interface BankDatasource {
    fun retrieveBanks(): Collection<Bank>
}