package com.example.lottery

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lottery.databinding.ActivitySelectnumBinding

class SelectNumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivitySelectnumBinding = ActivitySelectnumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_back = binding.back

        btn_back.setOnClickListener {

            finish()

        }
    }

}