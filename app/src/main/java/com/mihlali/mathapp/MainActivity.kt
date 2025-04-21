package com.mihlali.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
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
        val RadioGroup = findViewById<RadioGroup>(R.id.RadioGroup)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val radioAdd = findViewById<TextView>(R.id.radioAdd)
        val radioSubtract = findViewById<TextView>(R.id.radioSubtract)
        val radioMultiply = findViewById<TextView>(R.id.radioMultiply)
        val radioDivide = findViewById<TextView>(R.id.radioDivide)
        val answer = findViewById<TextView>(R.id.textAnswer)

        //setting what happens when the button is clicked
        btnCalculate.setOnClickListener {
            //get the values from the edit texts
            val valueOne = inputOne.text.toString().trim()
            val valueTwo = inputTwo.text.toString().trim()
            //check if the values are empty
            if (valueOne.isEmpty() || valueTwo.isEmpty()) {
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //convert the values to integers
            val num1 = valueOne.toInt()
            val num2 = valueTwo.toInt()
            //check which radio button is selected
            val selectedId = RadioGroup.checkedRadioButtonId
            //check if no radio button is selected
            if (selectedId == -1) {
                //if no radio button is selected, show a toast message
                Toast.makeText(this, "Please select an operation", Toast.LENGTH_SHORT).show()
                return@setOnClickListener }
            var result = 0
            var operation = ""
            if (selectedId == radioAdd.id) {
                //if the add radio button is selected, perform addition
                result = num1 + num2
                operation = "Addition"
                answer.text = "Answer: $result"
                Toast.makeText(this, "$operation done", Toast.LENGTH_SHORT).show()
            }else if (selectedId == radioSubtract.id) {
                //if the subtract radio button is selected, perform subtraction
                result = num1 - num2
                operation = "Subtraction"
                answer.text = "Answer: $result"
                Toast.makeText(this, "$operation done", Toast.LENGTH_SHORT).show()
            }else if (selectedId == radioMultiply.id) {
                //if the multiply radio button is selected, perform multiplication
                result = num1 * num2
                operation = "Multiplication"
                answer.text = "Answer: $result"
                Toast.makeText(this, "$operation done", Toast.LENGTH_SHORT).show()
            }else if (selectedId == radioDivide.id) {
                //if the divide radio button is selected, perform division
                if (num2 != 0) {
                    result = num1 / num2
                    operation = "Division"
                    //show a toast message with the result and operation
                    Toast.makeText(this, "$operation done", Toast.LENGTH_SHORT).show()
                 answer.text = "Answer: $result"}
                //if the second value is zero, show a toast message
                else { Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}
