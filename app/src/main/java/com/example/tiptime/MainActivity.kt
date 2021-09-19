package com.example.tiptime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnCalculate = binding.btnCalculate
        btnCalculate.setOnClickListener { calculateTip() }
    }

    fun calculateTip(){
        val costStr = binding.edtCost.text.toString()
        val cost= costStr.toDouble()

        val selectedId = binding.optionsTip.checkedRadioButtonId
        val percentage = when (selectedId){
            R.id.option20 -> 0.2
            R.id.option18 -> 0.18
            else -> 0.15
        }

        var tipAmount = cost * percentage

        val roundup = binding.switchRoundup.isChecked
        if(roundup)
            tipAmount = kotlin.math.ceil(tipAmount)

        val formattedTip = NumberFormat.getCurrencyInstance().format(tipAmount)
        val output = "Tip Amount: " + formattedTip

        val intent = Intent(this, OutputActivity::class.java)
        intent.putExtra("amount", output)
        startActivity(intent)
    }
}