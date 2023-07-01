package com.summerpractice.hw

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nameEditText = findViewById<EditText>(R.id.editNameText)
        val heightEditText = findViewById<EditText>(R.id.editHeightNumber)
        val weightEditText = findViewById<EditText>(R.id.editWeightNumber)
        val ageEditText = findViewById<EditText>(R.id.editAgeNumber)
        val answer = findViewById<TextView>(R.id.answerTextView)

        val clickButton = findViewById<Button>(R.id.startButton)

        clickButton?.setOnClickListener {
            val calculated = calculate(nameEditText, heightEditText, weightEditText, ageEditText)

            if (calculated != -1) {
                answer.text = "Answer: $calculated"
            } else {
                answer.text = "Incorrect data"
            }
        }
    }

    private fun calculate(nameEditText: EditText,
                          heightEditText: EditText,
                          weightEditText: EditText,
                          ageEditText: EditText) : Int {

        val name = nameEditText.text.toString()
        val height = heightEditText.text.toString().toDoubleOrNull()
        val weight = weightEditText.text.toString().toDoubleOrNull()
        val age = ageEditText.text.toString().toDoubleOrNull()

        if (height != null && weight != null && age != null) {
            if (name.length in 1..50
                && height in 1.0..249.0
                && weight in 1.0..249.0
                && age in 1.0..149.0) return ((height + weight + age) / name.length).toInt()
        }
        return -1
    }
}