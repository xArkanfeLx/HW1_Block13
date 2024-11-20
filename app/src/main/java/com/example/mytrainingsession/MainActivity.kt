package com.example.mytrainingsession

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarTB: Toolbar
    private lateinit var chooseBTN: Button
    private lateinit var startBTN: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)

        chooseBTN = findViewById(R.id.chooseBTN)
        startBTN = findViewById(R.id.startBTN)

        chooseBTN.setOnClickListener {
            intent = Intent(this, ChooseTrainingActivity::class.java)
            startActivity(intent)
        }
        startBTN.setOnClickListener {
            intent = Intent(this, Training_Activity::class.java)
            intent.putExtra("fullTraining", true)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}