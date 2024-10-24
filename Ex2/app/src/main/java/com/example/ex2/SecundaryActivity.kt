package com.example.ex2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecundaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secundary) // Es muy importante el layout que se carga, si no no reconocerá los id

        val volver: Button = findViewById(R.id.volverMain)


        volver.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }



    }
}