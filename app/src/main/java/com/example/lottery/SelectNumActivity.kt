package com.example.lottery

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lottery.databinding.ActivitySelectnumBinding

class SelectNumActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val binding : ActivitySelectnumBinding = ActivitySelectnumBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}