package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class ConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumption)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtConsumo = findViewById<TextInputEditText>(R.id.txt_consumo)
        val btnPromixo2 = findViewById<Button>(R.id.btn_proximo2)

        btnPromixo2.setOnClickListener {
            val txtConsumoStr = txtConsumo.text.toString()
            if (txtConsumoStr == "") {
                Snackbar
                    .make(
                        txtConsumo,
                        "Peencha o campo para seguir",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val consumo = txtConsumoStr.toFloat()
                val intent = Intent(this, DistanceActivity::class.java)
                startActivity(intent)
            }
        }
    }
}