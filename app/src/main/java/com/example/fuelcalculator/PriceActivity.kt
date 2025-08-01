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
import com.google.android.material.textfield.TextInputLayout

const val PRICE_KEY = "PriceActivity.PRICE_KEY"

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtPrice = findViewById<TextInputEditText>(R.id.txt_price)
        val btnProximo = findViewById<Button>(R.id.btn_proximo1)

        btnProximo.setOnClickListener {
            var txtPriceStr = txtPrice.text.toString()
            if (txtPriceStr == "") {
                Snackbar
                    .make(
                        txtPrice,
                        "Preencha o campo acima para seguir" ,
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                var preco = txtPriceStr.toFloat()
                var intent = Intent(this, ConsumptionActivity::class.java)
                intent.putExtra(PRICE_KEY , preco)
                startActivity(intent)
            }
        }
    }
}