package com.example.pizzaapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzaapp.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinish.setOnClickListener {
            // Implement payment logic
        }
    }
}

