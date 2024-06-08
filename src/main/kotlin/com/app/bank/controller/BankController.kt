package com.app.bank.controller

import com.app.bank.models.Bank
import com.app.bank.services.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/banks")
class BankController(private val bankService: BankService) {
    @GetMapping
    fun getBanks() = bankService.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBankByAccountNumber(@PathVariable accountNumber: String): Bank
    = bankService.getBanksByAccountNumber(accountNumber)
}