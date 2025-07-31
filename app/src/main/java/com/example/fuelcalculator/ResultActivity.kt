package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val RESULT_KEY = "ResultActivity.RESULT_KEY"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val preco = intent.getFloatExtra(PRICE_KEY , 0.0f)
        val consumo = intent.getFloatExtra(CONSUMPTION_KEY , 0.0f)
        val distancia = intent.getFloatExtra(DISTANCE_KEY , 0.0f)
        val resultado = intent.getFloatExtra(RESULT_KEY , 0.0f)

        val precoFlt = findViewById<TextView>(R.id.txt_valorPreco)
        val consumoFlt = findViewById<TextView>(R.id.txt_valorConsumo)
        val distanciaFlt = findViewById<TextView>(R.id.txt_valorDistancia)
        val resultadoFlt = findViewById<TextView>(R.id.txt_valorResultado)
        val btn_NovoCalculo = findViewById<Button>(R.id.btn_NovoCalculo)

        precoFlt.text = preco.toString()
        consumoFlt.text = consumo.toString()
        distanciaFlt.text = distancia.toString()
        resultadoFlt.text = resultado.toString()

        btn_NovoCalculo.setOnClickListener {
            val intent = Intent(this , PriceActivity::class.java)
            startActivity(intent)
        }
    }
}