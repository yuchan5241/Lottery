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

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Num_Data_Class>
    lateinit var numlist: Array<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySearchBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_back = binding.back

        //이 변수에 로또 번호 크롤링한 데이터들을 집어넣음
        numlist = arrayOf(
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5",
            "제 1 회 0 1 2 3 4 5")

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //아이템 간 간격
        recyclerView.addItemDecoration(SpaceItemDecoration(20))


        dataList = arrayListOf<Num_Data_Class>()
        getData()

        btn_back.setOnClickListener {

            finish()
        }

    }

    private fun getData(){
        for(i in numlist.indices){
            val numDataClass = Num_Data_Class(numlist[i])
            dataList.add(numDataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }
}