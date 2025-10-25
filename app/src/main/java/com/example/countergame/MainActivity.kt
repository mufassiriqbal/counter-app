package com.example.countergame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    
    private var scoreA = 0
    private var scoreB = 0


    private lateinit var aScoreTextView: TextView
    private lateinit var bScoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

 

        aScoreTextView = findViewById(R.id.AScore)
        bScoreTextView = findViewById(R.id.BScore)

        val increBtnA: Button = findViewById(R.id.increBtnAteam)
        val decreBtnA: Button = findViewById(R.id.decreBtnAteam)
        val increBtnB: Button = findViewById(R.id.increBtnBteam)
        val decreBtnB: Button = findViewById(R.id.decreBtnBteam) // Correct ID for Team B's decrement button
        val resetBtn: Button = findViewById(R.id.resetBtn)

        // 4. Set click listeners to update the scores when buttons are pressed

        // Team A Listeners
        increBtnA.setOnClickListener {
            scoreA++
            aScoreTextView.text = scoreA.toString()
        }
        decreBtnA.setOnClickListener {
            if (scoreA > 0) {
                scoreA--
                aScoreTextView.text = scoreA.toString()
            }
        }

        // Team B Listeners
        increBtnB.setOnClickListener {
            scoreB++
            bScoreTextView.text = scoreB.toString()
        }
        decreBtnB.setOnClickListener {
            if (scoreB > 0) {
                scoreB--
                bScoreTextView.text = scoreB.toString()
            }
        }

        // Reset Listener
        resetBtn.setOnClickListener {
            scoreA = 0
            scoreB = 0
            aScoreTextView.text = scoreA.toString()
            bScoreTextView.text = scoreB.toString()
        }
    }
}
