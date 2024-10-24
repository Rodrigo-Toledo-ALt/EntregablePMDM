package com.example.ex1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val enviar: Button = findViewById(R.id.enviar)
        val URL: EditText = findViewById(R.id.URL)


        //llamamos a la función de validación de URL, si es válida, se intenta abrir  en un Intent
        enviar.setOnClickListener {
            val url = URL.text.toString()
            if (url.isEmpty()) {
                Toast.makeText(this, "Introduce una URL", Toast.LENGTH_SHORT).show()
            }else if(!isURL(url)) {
                Toast.makeText(this, "URL no válida", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))      //Se crea la variable como un objeto Intent que se le pasa como parámetros
                startActivity(intent)                                        // la acción ACTION_VIEW y la URL a la que se quiere acceder haciendo el Uri.parse.
            }                                                                //Luego, startActivity se encarga de realizar la acción solicitada por el Intent.


            //Ajuste de la aplicación al sistema, para que no se superponga con la barra de estado --> por defecto

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

    }
}

    //Función que valida si la URL introducida es válida

    private fun isURL(url: String): Boolean {
        return try {
            Uri.parse(url).scheme in listOf("http", "https")
        } catch (e: Exception) {
            false
        }

    }