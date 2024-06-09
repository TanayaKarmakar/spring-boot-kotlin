package com.app.bank.controller

import com.app.bank.models.Bank
import com.app.bank.services.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/banks")
class BankController(private val bankService: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(e: IllegalArgumentException): ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping
    fun getBanks() = bankService.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBankByAccountNumber(@PathVariable accountNumber: String): Bank
    = bankService.getBanksByAccountNumber(accountNumber)

    @PostMapping
    fun addNewBank(@RequestBody bank: Bank): ResponseEntity<Bank> {
        val bank = bankService.addNewBank(bank)
        return ResponseEntity(bank, HttpStatus.CREATED)
    }
}