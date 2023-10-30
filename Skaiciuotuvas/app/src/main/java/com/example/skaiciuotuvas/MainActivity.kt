package com.example.skaiciuotuvas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val currentInput = StringBuilder()
    private var operand1 = 0.0
    private var operand2 = 0.0
    private var operator = ""
    private val resultTextView = findViewById<TextView>(R.id.TextViewrezultatas)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigitClick(view: View) {
        val button = view as Button
        currentInput.append(button.text)
        updateResultText()
    }

    fun onOperatorClick(view: View) {
        operator = (view as Button).text.toString()
        operand1 = currentInput.toString().toDouble()
        currentInput.setLength(0)
    }

    fun onEqualsClick(view: View?) {
        operand2 = currentInput.toString().toDouble()
        val result = performOperation(operand1, operand2, operator)
        currentInput.setLength(0)
        currentInput.append(result)
        updateResultText()
    }

    fun onClearClick(view: View?) {
        currentInput.setLength(0)
        operand1 = 0.0
        operand2 = 0.0
        operator = ""
        updateResultText()
    }

    private fun performOperation(operand1: Double, operand2: Double, operator: String): Double {
        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> {
                if (operand2 == 0.0) {
                    Double.NaN
                } else operand1 / operand2
            }

            else -> operand2
        }
    }

    private fun updateResultText() {
        resultTextView!!.text = currentInput.toString()
    }
}