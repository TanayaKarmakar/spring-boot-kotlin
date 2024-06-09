package com.app.bank.datasource.network

import com.app.bank.datasource.BankDatasource
import com.app.bank.models.Bank
import com.app.bank.models.dtos.BankList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
        @Autowired private val restTemplate: RestTemplate
): BankDatasource {
    override fun retrieveBanks(): Collection<Bank> {
        val response: ResponseEntity<BankList>
        = restTemplate.getForEntity<BankList>("http://54.193.31.159/banks")

        return response.body?.results
                ?: throw IOException("Could not fetch bank from network")
    }

    override fun retrieveBankByAccountNumber(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun addNewBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNumber: String): Any {
        TODO("Not yet implemented")
    }
}