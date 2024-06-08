package com.app.bank.services

import com.app.bank.datasource.BankDatasource
import com.app.bank.models.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val bankDataSource: BankDatasource) {
    fun getBanks(): Collection<Bank> = bankDataSource.retrieveBanks()

}