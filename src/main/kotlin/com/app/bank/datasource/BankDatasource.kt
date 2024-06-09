package com.app.bank.datasource

import com.app.bank.models.Bank

interface BankDatasource {
    fun retrieveBanks(): Collection<Bank>
    abstract fun retrieveBankByAccountNumber(accountNumber: String): Bank
    abstract fun addNewBank(bank: Bank): Bank
    abstract fun updateBank(bank: Bank): Bank
    abstract fun deleteBank(accountNumber: String): Any
}