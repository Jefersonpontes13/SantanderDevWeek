package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
        // throw RuntimeException("Test crash")

    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta : Conta) {
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome.split(" ")[0]
        findViewById<TextView>(R.id.tv_numero_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_numero_conta).text = conta.numero
        findViewById<TextView>(R.id.tv_valor_saldo_disponivel).text = conta.saldo.toString()
        findViewById<TextView>(R.id.tv_valor_saldo_mais_limite).text = (conta.saldo + conta.limite).toString()
        findViewById<TextView>(R.id.tv_numeros_cartao_final).text = conta.cartao.numeroCartao.split(" ")[3]
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.notificacoes -> {
                Log.d("CLICK", "Click on Notificações")
                true
            }
            R.id.opcoes -> {
                Log.d("CLICK", "Click on Opções")
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}