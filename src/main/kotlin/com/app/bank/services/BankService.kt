package com.app.bank.services

import com.app.bank.datasource.BankDatasource
import com.app.bank.models.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankService(@Qualifier("mock") private val bankDataSource: BankDatasource) {
    fun getBanks(): Collection<Bank> = bankDataSource.retrieveBanks()

    fun getBanksByAccountNumber(accountNumber: String): Bank = bankDataSource.retrieveBankByAccountNumber(accountNumber)

    fun addNewBank(bank: Bank): Bank = bankDataSource.addNewBank(bank)

    fun updateBank(bank: Bank): Bank = bankDataSource.updateBank(bank)

    fun deleteBank(accountNumber: String) = bankDataSource.deleteBank(accountNumber)

}