package com.example.santanderdevweek.data

data class Conta(
    val numero: String,
    val agencia: String,
    val saldo: Double,
    val limite: Double,
    val cliente: Cliente,
    val cartao: Cartao
)