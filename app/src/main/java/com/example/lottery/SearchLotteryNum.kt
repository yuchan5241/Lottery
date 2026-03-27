package com.example.lottery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lottery.databinding.ActivityMainBinding
import com.example.lottery.databinding.ActivitySearchBinding

class SearchLotteryNum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySearchBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val data = listOf("사과", "배", "포도", "수박")

        recyclerView.layoutManager = LinearLayoutManager(this) // 세로 리스트형
        recyclerView.adapter = RecyclerViewAdapter(data)
        val btn_back = binding.back

        btn_back.setOnClickListener {

            finish()
        }
    }
}