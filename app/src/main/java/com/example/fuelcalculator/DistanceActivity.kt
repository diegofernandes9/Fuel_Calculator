package com.example.fuelcalculator
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val consumo = intent.getFloatExtra(CONSUMPTION_KEY , 0.0f)
        val preco = intent.getFloatExtra(PRICE_KEY , 0.0f)

        val txtDistancia = findViewById<TextInputEditText>(R.id.txt_distancia)
        val btnResultado = findViewById<Button>(R.id.btn_Resultado)

        btnResultado.setOnClickListener {
            var txtDistanciaStr = txtDistancia.text.toString()
            if (txtDistanciaStr == "") {
                Snackbar
                    .make(
                        txtDistancia,
                        "Preencha o último campo para ter o resultado",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val distancia = txtDistanciaStr.toFloat()

                val resultado = (distancia/consumo)*preco
                println(resultado)
            }
        }
    }
}