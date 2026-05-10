package com.br.atv3

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editUsername: EditText
    private lateinit var editPassword: EditText
    private lateinit var switchLembrar: Switch
    private lateinit var btnEntrar: Button
    private lateinit var sharedPreferences: SharedPreferences

    private val PREFS_NAME = "PREFERENCIAS"
    private val CHAVE_USERNAME = "username"
    private val CHAVE_LEMBRAR = "lembrar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        editUsername = findViewById(R.id.editUsername)

        editPassword = findViewById(R.id.editPassword)

        switchLembrar = findViewById(R.id.switchLembrar)

        btnEntrar = findViewById(R.id.btnEntrar)

        sharedPreferences = getSharedPreferences(
            PREFS_NAME,
            MODE_PRIVATE
        )

        val lembrar =
            sharedPreferences.getBoolean(
                CHAVE_LEMBRAR,
                false
            )

        if (lembrar) {

            val usernameSalvo =
                sharedPreferences.getString(
                    CHAVE_USERNAME,
                    ""
                )

            editUsername.setText(usernameSalvo)
            switchLembrar.isChecked = true
        }

        btnEntrar.setOnClickListener {

            val username = editUsername.text.toString()

            val lembrarMarcado = switchLembrar.isChecked

            val editor = sharedPreferences.edit()

            if (lembrarMarcado){

                editor.putString(
                    CHAVE_USERNAME,
                    username
                )

                editor.putBoolean(
                    CHAVE_LEMBRAR,
                    true
                )

            }
            else {

                editor.remove(CHAVE_USERNAME)

                editor.putBoolean(
                    CHAVE_LEMBRAR,
                    false

                )
            }

            editor.apply()

            Toast.makeText(
                this,
                "Login realizado",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}