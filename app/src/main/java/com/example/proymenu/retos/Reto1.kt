package com.example.proymenu.retos

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.R
import com.google.android.material.button.MaterialButton

class Reto1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ladoEditText = findViewById<EditText>(R.id.lado)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        val btnCalcularArea = findViewById<MaterialButton>(R.id.btn_CalcularArea)

        btnCalcularArea.setOnClickListener {
            val ladoText = ladoEditText.text.toString()

            if (ladoText.isNotEmpty()) {
                try {

                    val lado = ladoText.toDouble()


                    val area = lado * lado

                    resultadoTextView.text = "Área: $area"

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor, ingresa un número válido", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, "Por favor, ingresa el lado del cuadrado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}