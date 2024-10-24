package com.example.ex2

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // Es muy importante el layout que se carga, si no no reconocerá los id

        val irSecundaria: Button = findViewById(R.id.cambiar)

        irSecundaria.setOnClickListener {

            val intent = Intent(this, SecundaryActivity::class.java)                                              // el parámetro context es una especie de conexión entre el código y
            val pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_IMMUTABLE) // la parte de la aplicación con la que se relaciona (en este caso, la MainActivity

            Handler(Looper.getMainLooper()).postDelayed({       //Handler ejecutará en el hilo principal de la app, que es donde
                try{                                            //se ejecuta el código de la interfaz de usuario, el código dentro del postDelayed
                    pendingIntent.send()                         // como primer argumento?
                }catch (e: PendingIntent.CanceledException){
                    e.printStackTrace()
                }
            }, 5000) // 1000 milisegundos = 1 segundo

        }














        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}