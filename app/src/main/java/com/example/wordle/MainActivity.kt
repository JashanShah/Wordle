package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.wordle.R
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter = 1
        val guessButton = findViewById<Button>(R.id.guessButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val input = findViewById<EditText>(R.id.userInput)
        val guess1Input = findViewById<TextView>(R.id.guess1Input)
        val guess1InputCheck = findViewById<TextView>(R.id.guess1InputCheck)
        val guess2Input = findViewById<TextView>(R.id.guess2Input)
        val guess2InputCheck = findViewById<TextView>(R.id.guess2InputCheck)
        val guess3Input = findViewById<TextView>(R.id.guess3Input)
        val guess3InputCheck = findViewById<TextView>(R.id.guess3InputCheck)
        val answer = findViewById<TextView>(R.id.answer)
        guessButton.setOnClickListener {
            when (counter) {
                1 -> {
                    var theInput : String = input.text.toString()
                    guess1Input.text = theInput
                    guess1Input.visibility = View.VISIBLE
                    guess1InputCheck.text = checkGuess(theInput)
                    guess1InputCheck.visibility = View.VISIBLE
                    counter++
                }
                2 -> {
                    var theInput : String = input.text.toString()
                    guess2Input.text = theInput
                    guess2Input.visibility = View.VISIBLE
                    guess2InputCheck.text = checkGuess(theInput)
                    guess2InputCheck.visibility = View.VISIBLE
                    counter++
                }
                else -> {
                    var theInput : String = input.text.toString()
                    guess3Input.text = theInput
                    guess3Input.visibility = View.VISIBLE
                    guess3InputCheck.text = checkGuess(theInput)
                    guess3InputCheck.visibility = View.VISIBLE
                    counter++
                    //Need to grey out and disable guess button and have a reset button appear.
                    guessButton.isEnabled = false
                    resetButton.visibility = View.VISIBLE
                    answer.setText(wordToGuess)
                    answer.visibility = View.VISIBLE
                }
            }



        }

        resetButton.setOnClickListener {
            counter = 0
            guess1Input.visibility = View.INVISIBLE
            guess2Input.visibility = View.INVISIBLE
            guess3Input.visibility = View.INVISIBLE
            guess1InputCheck.visibility = View.INVISIBLE
            guess2InputCheck.visibility = View.INVISIBLE
            guess3InputCheck.visibility = View.INVISIBLE
            guessButton.isEnabled = true
            wordToGuess = word.getRandomFourLetterWord()
            input.setText("")
            resetButton.visibility = View.INVISIBLE
            answer.visibility = View.INVISIBLE
        }

    }

    var word = FourLetterWordList()
    var wordToGuess :String = word.getRandomFourLetterWord()

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }





}