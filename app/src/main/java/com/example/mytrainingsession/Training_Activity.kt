package com.example.mytrainingsession

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Training_Activity : AppCompatActivity() {

    val exercises = ExersiceDataBase.exercises
    var fullTraining = true;
    var exerciseNumber = 0;

    private lateinit var toolbarTB: Toolbar
    private lateinit var nextBTN: Button
    private lateinit var nameTV: TextView
    private lateinit var descriptionTV: TextView
    private lateinit var countTV: TextView
    private lateinit var exersiceIV: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_training)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
    }

    private fun startExercise() {
        nameTV.text = exercises[exerciseNumber].name
        descriptionTV.text = exercises[exerciseNumber].description
        countTV.text = exercises[exerciseNumber].count
        exersiceIV.setImageResource(exercises[exerciseNumber].gifImage)
        exerciseNumber++
        if (exerciseNumber == exercises.size) nextBTN.isEnabled = false
    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)

        nameTV = findViewById(R.id.nameTV)
        descriptionTV = findViewById(R.id.descriptionTV)
        descriptionTV = findViewById(R.id.descriptionTV)
        countTV = findViewById(R.id.countTV)
        nextBTN = findViewById(R.id.nextBTN)
        exersiceIV = findViewById(R.id.exersiceIV)

        fullTraining = intent.extras!!.getBoolean("fullTraining")

        if (fullTraining) {
            nextBTN.isEnabled = true
        } else {
            exerciseNumber = intent.extras!!.getInt("exerciseNumber")
        }

        startExercise()

        nextBTN.setOnClickListener { startExercise() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_other, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}