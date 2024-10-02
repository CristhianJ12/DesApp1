package com.example.proymenu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.retos.Reto1
import com.example.proymenu.retos.Reto3
import com.example.proymenu.retos.Reto4
import com.example.proymenu.retos.Reto5
import com.example.proymenu.retos.Reto6
import com.example.proymenu.retos.Reto7
import com.example.proymenu.retos.Reto8
import com.example.proymenu.retos.Reto9
import com.example.proymenu.retos.Reto10
import com.example.proymenu.retos.Reto2

class RetosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Si tienes esta función definida en tu clase
        setContentView(R.layout.activity_retos)

        // Declaración de botones
        val button1 = findViewById<AppCompatButton>(R.id.Reto1_btn)
        val button2 = findViewById<AppCompatButton>(R.id.Reto2_btn)
        val button3 = findViewById<AppCompatButton>(R.id.Reto3_btn)
        val button4 = findViewById<AppCompatButton>(R.id.Reto4_btn)
        val button5 = findViewById<AppCompatButton>(R.id.Reto5_btn)
        val button6 = findViewById<AppCompatButton>(R.id.Reto6_btn)
        val button7 = findViewById<AppCompatButton>(R.id.Reto7_btn)
        val button8 = findViewById<AppCompatButton>(R.id.Reto8_btn)
        val button9 = findViewById<AppCompatButton>(R.id.Reto9_btn)
        val button10 = findViewById<AppCompatButton>(R.id.Reto10_btn)

        // Configuración de clics para cada botón
        button1.setOnClickListener { toReto1() }
        button2.setOnClickListener { toReto2() }
        button3.setOnClickListener { toReto3() }
        button4.setOnClickListener { toReto4() }
        button5.setOnClickListener { toReto5() }
        button6.setOnClickListener { toReto6() }
        button7.setOnClickListener { toReto7() }
        button8.setOnClickListener { toReto8() }
        button9.setOnClickListener { toReto9() }
        button10.setOnClickListener { toReto10() }

        // Configuración de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun toReto1() {
        Log.d("MenuActivity", "Botón de Reto 1 presionado")
        val lanzar1 = Intent(this, Reto1::class.java)
        startActivity(lanzar1)
    }

    private fun toReto2() {
        Log.d("MenuActivity", "Botón de Reto 2 presionado")
        val lanzar2 = Intent(this, Reto2::class.java)
        startActivity(lanzar2)
    }

    private fun toReto3() {
        Log.d("MenuActivity", "Botón de Reto 3 presionado")
        val lanzar3 = Intent(this, Reto3::class.java)
        startActivity(lanzar3)
    }

    private fun toReto4() {
        Log.d("MenuActivity", "Botón de Reto 4 presionado")
        val lanzar4 = Intent(this, Reto4::class.java)
        startActivity(lanzar4)
    }

    private fun toReto5() {
        Log.d("MenuActivity", "Botón de Reto 5 presionado")
        val lanzar5 = Intent(this, Reto5::class.java)
        startActivity(lanzar5)
    }

    private fun toReto6() {
        Log.d("MenuActivity", "Botón de Reto 6 presionado")
        val lanzar6 = Intent(this, Reto6::class.java)
        startActivity(lanzar6)
    }

    private fun toReto7() {
        Log.d("MenuActivity", "Botón de Reto 7 presionado")
        val lanzar7 = Intent(this, Reto7::class.java)
        startActivity(lanzar7)
    }

    private fun toReto8() {
        Log.d("MenuActivity", "Botón de Reto 8 presionado")
        val lanzar8 = Intent(this, Reto8::class.java)
        startActivity(lanzar8)
    }

    private fun toReto9() {
        Log.d("MenuActivity", "Botón de Reto 9 presionado")
        val lanzar9 = Intent(this, Reto9::class.java)
        startActivity(lanzar9)
    }

    private fun toReto10() {
        Log.d("MenuActivity", "Botón de Reto 10 presionado")
        val lanzar10 = Intent(this, Reto10::class.java)
        startActivity(lanzar10)
    }
}