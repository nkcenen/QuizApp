package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val firstQuestionAnswer = "Joe"
    private val secondQuestionAnswer = "1960"

    private var firstQuestionEt: EditText? = null
    private var secondQuestionEt: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstQuestionEt = findViewById(R.id.first_question_et)
        secondQuestionEt = findViewById(R.id.second_question_et)

        val submitButton = findViewById<Button>(R.id.submit_button)

        submitButton.setOnClickListener {
            checkAnswersAndSubmit()
        }
    }

    private fun checkAnswersAndSubmit() {
        if (validateEditTexts() && checkIfFirstAnswersCorrect() && checkIfSecondAnswersCorrect()) {
            showToast("Brilliant! Click next to continue")
        }
    }

    private fun checkIfFirstAnswersCorrect(): Boolean {
        return when {
            firstQuestionEt!!.text.toString().equals(firstQuestionAnswer, ignoreCase = true)-> {
                true
            }

            else -> {
                showToast("First Answer is incorrect")
                false
            }
        }
    }

    private fun checkIfSecondAnswersCorrect(): Boolean {
        return when {
            secondQuestionEt!!.text.toString().equals(secondQuestionAnswer, ignoreCase = true) -> {
                true
            }

            else -> {
                showToast("Second Answer is incorrect")
                false
            }
        }
    }

    private fun validateEditTexts(): Boolean {

        if (firstQuestionEt?.text!!.isEmpty()) {
            showToast("No Answer provided for the First Question")
            return false
        }
        if (secondQuestionEt?.text!!.isEmpty()) {
            showToast("No Answer provided for the Second Question")
            return false
        }
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}