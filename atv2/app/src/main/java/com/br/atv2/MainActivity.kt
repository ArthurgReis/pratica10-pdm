package com.br.atv2

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textContador: TextView
    private lateinit var btnClique: Button
    private lateinit var sharedPreferences: SharedPreferences

    private var contador = 0

    private val PREFS_NAME = "PREFERENCIAS"
    private val CHAVE_CONTADOR = "contador"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        textContador = findViewById(R.id.textContador)
        btnClique = findViewById(R.id.btnClique)

        sharedPreferences = getSharedPreferences(
            PREFS_NAME,
            MODE_PRIVATE
        )

        contador =
            sharedPreferences.getInt(
                CHAVE_CONTADOR,
                0
            )

        textContador.text = contador.toString()

        btnClique.setOnClickListener {

            contador++

            textContador.text =
                contador.toString()

            sharedPreferences.edit()
                .putInt(
                    CHAVE_CONTADOR,
                    contador
                )
                .apply()
        }
    }
}