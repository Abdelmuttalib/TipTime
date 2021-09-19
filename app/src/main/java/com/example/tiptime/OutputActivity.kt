package com.example.tiptime

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OutputActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val txt = findViewById<TextView>(R.id.txt_output)
        val intent = getIntent()
        val output = intent.getStringExtra("amount")
        txt.text = output
    }
}