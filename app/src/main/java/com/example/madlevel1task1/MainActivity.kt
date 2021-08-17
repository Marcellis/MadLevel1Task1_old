package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.madlevel1task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

            binding.btnLower.setOnClickListener {
                onLowerClick()
            }
            binding.btnEqual.setOnClickListener {
                onEqualClick()
            }
            binding.btnHigher.setOnClickListener {
                onHigherClick()
            }
            updateUI()
      
    }

    private fun updateUI() {

        when (currentThrow) {
            1 -> binding.ivDice.setImageResource(R.drawable.dice1)
            2 -> binding.ivDice.setImageResource(R.drawable.dice2)
            3 -> binding.ivDice.setImageResource(R.drawable.dice3)
            4 -> binding.ivDice.setImageResource(R.drawable.dice4)
            5 -> binding.ivDice.setImageResource(R.drawable.dice5)
            6 -> binding.ivDice.setImageResource(R.drawable.dice6)
        }

        binding.tvLastThrow.text = getString (R.string.last_throw, lastThrow)



    }

    /**
     * Replaces the previous dice value with the current one and replaces the current dice with a new dice
     * with a random number between 1 and 6 (inclusive).
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }


    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()
        //Implement this function yourself!
        if (currentThrow > lastThrow ) showAnswerFeedback (true)
        else showAnswerFeedback (false)
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        //Implement this function yourself!
        if (currentThrow < lastThrow ) showAnswerFeedback (true)
        else showAnswerFeedback (false)
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        //Implement this function yourself!
        if (currentThrow == lastThrow ) showAnswerFeedback (true)
        else showAnswerFeedback (false)
    }

    /**
     * Displays a message based on a whether the answer is correct
     */
    /**
     * Displays a message based on a whether the answer is correct
     */
    private fun showAnswerFeedback(answerIsCorrect: Boolean) {
        @StringRes
        val messageRes = if (answerIsCorrect) R.string.correct else R.string.incorrect

        Toast.makeText(this, getString(messageRes), Toast.LENGTH_SHORT).show()
    }
}