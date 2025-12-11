package com.example.lottery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lottery.databinding.ActivityMainBinding
import com.example.lottery.databinding.ActivitySearchBinding

class SearchLotteryNum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySearchBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_back = binding.back

        btn_back.setOnClickListener {

            finish()
        }
    }
}