package com.example.proymenu.retos

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.R

class Reto5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sueldoBasicoInput = findViewById<EditText>(R.id.sueldo_basico)
        val antiguedadInput = findViewById<EditText>(R.id.antiguedad)
        val btnCalcularTotal = findViewById<MaterialButton>(R.id.btn_calcular_total)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        btnCalcularTotal.setOnClickListener {
            val sueldoBasicoTexto = sueldoBasicoInput.text.toString()
            val antiguedadTexto = antiguedadInput.text.toString()

            if (sueldoBasicoTexto.isEmpty() || antiguedadTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa todos los datos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val sueldoBasico = sueldoBasicoTexto.toDouble()
                val antiguedad = antiguedadTexto.toInt()

                val bono = if (antiguedad > 10) {
                    sueldoBasico * 0.10
                } else {
                    sueldoBasico * 0.05
                }

                val total = sueldoBasico + bono

                resultadoText.text = "El total es: $total"
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingresa números válidos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}