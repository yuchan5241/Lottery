package com.example.lottery

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lottery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val btn_search = binding.startSearch
        val btn_select = binding.startLottery
        val btn_back = binding.back

        btn_search.setOnClickListener {
            val intent = Intent(this, SearchLotteryNum::class.java)
            startActivity(intent)
        }
        btn_select.setOnClickListener {
            val intent = Intent(this, SelectNumActivity::class.java)
            startActivity(intent)
        }
        btn_back.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setTitle("앱을 종료할까요?")
                .setPositiveButton("아니요",
                    DialogInterface.OnClickListener{ dialog, which ->

                    })
                .setNegativeButton("네",
                    DialogInterface.OnClickListener{ dialog, which ->
                        finish()
                    })

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

    }


}