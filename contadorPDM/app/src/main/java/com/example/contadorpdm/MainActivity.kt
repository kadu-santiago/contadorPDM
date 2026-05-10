package com.example.contadorpdm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvContador: TextView
    private lateinit var btnAdc: Button
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvContador = findViewById(R.id.tv_contador)
        btnAdc = findViewById(R.id.btn_adc)

        recuperarDados()
        tvContador.text = contador.toString()

        btnAdc.setOnClickListener {
            contador++
            tvContador.text = contador.toString()
            salvarDados()
        }
    }

    private fun recuperarDados() {
        val sharedPref = getSharedPreferences("VAL_CONTADOR", MODE_PRIVATE)
        contador = sharedPref.getInt("CONTADOR_SALVO", 0)
    }

    private fun salvarDados() {
        val sharedPref = getSharedPreferences("VAL_CONTADOR", MODE_PRIVATE)
        sharedPref.edit {
            putInt("CONTADOR_SALVO", contador)
        }
    }
}