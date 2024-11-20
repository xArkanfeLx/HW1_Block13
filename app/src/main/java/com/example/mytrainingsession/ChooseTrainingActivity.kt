package com.example.mytrainingsession

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChooseTrainingActivity : AppCompatActivity() {

    val exercises = ExersiceDataBase.exercises

    private lateinit var toolbarTB: Toolbar
    private lateinit var productsLV: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose_training)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)

        productsLV = findViewById(R.id.exersicesLV)
        val listAdapter = ListAdapter(this@ChooseTrainingActivity,exercises)
        productsLV.adapter = listAdapter
        listAdapter.notifyDataSetChanged()

        productsLV.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            intent = Intent(this, Training_Activity::class.java)
            intent.putExtra("fullTraining", false)
            intent.putExtra("exerciseNumber", id.toInt())
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_other,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}