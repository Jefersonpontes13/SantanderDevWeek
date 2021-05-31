package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {

    fun getLocalData(): Conta {

        return Conta(
            "9999",
            "999999-9",
            "Corrente",
            9999.99,
            999.99,
            Cliente(
                "Francisco Jeferson da Silveira Pontes",
                "jeffersonpontes1313@gmail.com"),
            Cartao("9999 9999 9999 9999")
        )

    }
}