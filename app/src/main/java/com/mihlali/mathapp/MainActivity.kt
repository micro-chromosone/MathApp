package com.mihlali.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //start of code
        // connect variables to edit texts
        val inputOne = findViewById<EditText>(R.id.valueOne)
        val inputTwo = findViewById<EditText>(R.id.valueTwo)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val answer = findViewById<TextView>(R.id.textAnswer)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        //Button Listener Click Action for Divide
        btnDivide.setOnClickListener {
           val intTwo = inputOne.text.toString().toDoubleOrNull()
           val intThree = inputTwo.text.toString().toDoubleOrNull()
           if (intTwo != null && intThree != null){
               val newTotal = intTwo / intThree
               answer.setText(newTotal.toString())
           } else {
               Toast.makeText(this, "Please Enter A Valid Number", Toast.LENGTH_SHORT).show()
           }
        }

        //button Listener Click Action For Multiplication
        btnMultiply.setOnClickListener {
            val intKune = inputOne.text.toString().toDoubleOrNull() //kune is one in isiZulu
            val intKubili = inputTwo.text.toString().toDoubleOrNull() //kubili is two in isiZulu
            if (intKune != null && intKubili != null) {
                val newTotal = intKune * intKubili
                answer.setText(newTotal.toString())
            }else{
                Toast.makeText(this, "Please Enter A valid Number", Toast.LENGTH_SHORT).show()
            }
        }

         //button listener click action for subtraction
        btnSubtract.setOnClickListener {
            val intUno = inputOne.text.toString().toDoubleOrNull()
            val intDos = inputTwo.text.toString().toDoubleOrNull()
            if (intUno != null && intDos != null) {
                val newTotal = intUno - intDos
                answer.setText(newTotal.toString())
            } else{
                Toast.makeText(this, "Please Enter A Valid Number", Toast.LENGTH_SHORT).show()
            }
        }

        //button listener or click action
        btnCalculate.setOnClickListener {
            val intOne = inputOne.text.toString().toDoubleOrNull()
            val intTwo = inputTwo.text.toString().toDoubleOrNull()
            if (intOne != null && intTwo != null) {
                val newTotal = intOne + intTwo
                answer.setText(newTotal.toString())


        } else{
            Toast.makeText( this, "Please Enter A Valid Number", Toast.LENGTH_SHORT).show()
            }

          }
    }
}