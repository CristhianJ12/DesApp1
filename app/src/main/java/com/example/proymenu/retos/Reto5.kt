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

        // Configuración del botón para calcular el total
        btnCalcularTotal.setOnClickListener {
            // Obtener los valores ingresados
            val sueldoBasicoTexto = sueldoBasicoInput.text.toString()
            val antiguedadTexto = antiguedadInput.text.toString()

            // Validar que los campos no estén vacíos
            if (sueldoBasicoTexto.isEmpty() || antiguedadTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa todos los datos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // Convertir los valores a números
                val sueldoBasico = sueldoBasicoTexto.toDouble()
                val antiguedad = antiguedadTexto.toInt()

                // Calcular el bono
                val bono = if (antiguedad > 10) {
                    sueldoBasico * 0.10  // Bono del 10% si antigüedad > 10 años
                } else {
                    sueldoBasico * 0.05  // Bono del 5% si antigüedad <= 10 años
                }

                // Calcular el total
                val total = sueldoBasico + bono

                // Mostrar el resultado final
                resultadoText.text = "El total es: $total"
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                // Mostrar un mensaje si algún dato no es válido
                Toast.makeText(this, "Por favor, ingresa números válidos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}