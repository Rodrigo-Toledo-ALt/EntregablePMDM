package com.example.ex5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mostrar: TextView = findViewById(R.id.resultado)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)

        val buttonSumar: Button = findViewById(R.id.sumar)
        val buttonRestar: Button = findViewById(R.id.restar)
        val buttonMultiplicar: Button = findViewById(R.id.multiplicar)
        val buttonDividir: Button = findViewById(R.id.dividir)
        val buttonCalcular: Button = findViewById(R.id.calcular)

        val buttonClean: Button = findViewById(R.id.clean)

        var resultado:String = ""
        var operacion:String = ""
        var numero1:Double = 0.0
        var numero2:Double = 0.0

        /*
        Necesitamos

        función calcular
        onClickListener para cada botón para añadir al textview.text  el número

         */

        //los 9 onclickListener para los números
        val buttons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                mostrar.text = mostrar.text.toString() + (index).toString()
            }
        }



        //Los 4 onclickListener para cambiar la operación
        val buttonsOperacion = listOf(buttonSumar, buttonRestar, buttonMultiplicar, buttonDividir)
        buttonsOperacion.forEachIndexed { index, button ->
            button.setOnClickListener {
                numero1 = mostrar.text.toString().toDouble()
                mostrar.text= ""
                operacion= when(index){
                    0 -> "+"
                    1 -> "-"
                    2 -> "*"
                    3 -> "/"
                    else -> ""
                }
            }
        }

        buttonCalcular.setOnClickListener {
            numero2 = mostrar.text.toString().toDouble()
            resultado = calcular(operacion, numero1, numero2).toString()
            mostrar.text = resultado
        }


        buttonClean.setOnClickListener {
            mostrar.text = ""
            resultado = ""
            operacion = ""
            numero1 = 0.0
            numero2 = 0.0
        }


                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcular(operacion: String, numero1: Double, numero2: Double): Double {
        return when (operacion) {
            "+" -> numero1 + numero2
            "-" -> numero1 - numero2
            "*" -> numero1 * numero2
            "/" -> numero1 / numero2
            else -> 0.0
        }
    }

}