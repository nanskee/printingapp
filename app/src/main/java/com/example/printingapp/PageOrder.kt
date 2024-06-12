package com.example.printingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PageOrder : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_order)

        val button = findViewById<ImageButton>(R.id.backByrBtn).setOnClickListener {
            val intent = Intent(this,  //isi sama page yang buat upload file)
        }

        val button = findViewById<Button>(R.id.byrButton).setOnClickListener {
            val intent = Intent(this,  //isi sama page yang proses order)
        }

        val spinnerId =findViewById<Spinner>(R.id.pilihKirim)
        val jaskir = arrayOf("Hemat", "Reguler", "Kilat")
        val arrayAdp =
            ArrayAdapter(this@PageOrder, android.R.layout.simple_spinner_dropdown_item, jaskir)
        spinnerId.adapter = arrayAdp

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}