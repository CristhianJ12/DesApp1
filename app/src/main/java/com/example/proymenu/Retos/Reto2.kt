package com.example.proymenu.Retos

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

class Reto2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a las vistas
        val edadInput = findViewById<EditText>(R.id.edadInput)
        val precioInput = findViewById<EditText>(R.id.precioInput)
        val calcularButton = findViewById<MaterialButton>(R.id.calcularButton)
        val resultadoDescuento = findViewById<TextView>(R.id.resultadoDescuento)
        val resultadoTotal = findViewById<TextView>(R.id.resultadoTotal)

        // Acción del botón de calcular
        calcularButton.setOnClickListener {
            val edadTexto = edadInput.text.toString()
            val precioTexto = precioInput.text.toString()

            // Verificar si los campos no están vacíos
            if (edadTexto.isNotEmpty() && precioTexto.isNotEmpty()) {
                try {
                    val edad = edadTexto.toInt()
                    val precio = precioTexto.toDouble()

                    var descuento = 0.0

                    // Aplicar descuento si la edad es menor a 10 años
                    if (edad < 10) {
                        descuento = precio * 0.25
                    }

                    // Calcular el total a pagar
                    val total = precio - descuento

                    // Mostrar el descuento y el total
                    resultadoDescuento.text = "El descuento es: S/.${"%.2f".format(descuento)}"
                    resultadoTotal.text = "El total a pagar es: S/.${"%.2f".format(total)}"

                } catch (e: NumberFormatException) {
                    // Mostrar mensaje de error si los números no son válidos
                    Toast.makeText(this, "Por favor, ingresa valores válidos", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Mostrar mensaje si los campos están vacíos
                Toast.makeText(this, "Por favor, ingresa todos los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}