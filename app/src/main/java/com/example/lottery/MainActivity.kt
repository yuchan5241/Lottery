package com.example.lottery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lottery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val btn_search = binding.startSearch
        val btn_select = binding.startLottery

        btn_search.setOnClickListener {
            val intent = Intent(this, SearchLotteryNum::class.java)
            startActivity(intent)
        }
        btn_select.setOnClickListener {
            val intent = Intent(this, SelectNumActivity::class.java)
            startActivity(intent)
        }

    }


}