package com.app.bank.datasource.mock

import com.app.bank.datasource.BankDatasource
import com.app.bank.models.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource: BankDatasource {
    val banks = mutableListOf(
            Bank("1234", 3.14, 1),
            Bank("1010", 17.0, 10),
            Bank("1456", 18.8,19)
    )
    override fun retrieveBanks(): Collection<Bank> {
        return banks
    }

    override fun retrieveBankByAccountNumber(accountNumber: String): Bank
        = banks.first { it.accountNumber == accountNumber }

    override fun addNewBank(bank: Bank): Bank {
        if(banks.any{it.accountNumber == bank.accountNumber}) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
        }
        banks.add(bank)
        return bank
    }

}