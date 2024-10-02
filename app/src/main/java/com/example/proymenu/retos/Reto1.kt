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

        // Configurar la acción al hacer clic en el botón
        btnCalcularArea.setOnClickListener {
            // Obtener el valor del EditText (lado)
            val ladoText = ladoEditText.text.toString()

            // Verificar que no esté vacío
            if (ladoText.isNotEmpty()) {
                try {
                    // Convertir el valor ingresado a Double
                    val lado = ladoText.toDouble()

                    // Calcular el área del cuadrado (lado * lado)
                    val area = lado * lado

                    // Mostrar el resultado en el TextView
                    resultadoTextView.text = "Área: $area"

                } catch (e: NumberFormatException) {
                    // Mostrar mensaje si el formato es incorrecto
                    Toast.makeText(this, "Por favor, ingresa un número válido", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                // Mostrar un mensaje si el campo está vacío
                Toast.makeText(this, "Por favor, ingresa el lado del cuadrado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        //supportActionBar?.hide() -> Para ocultar el titulo del proyecto
    }
}