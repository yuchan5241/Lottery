package com.example.lottery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lottery.databinding.ActivityMainBinding
import com.example.lottery.databinding.ActivitySearchBinding
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.lang.Exception

class SearchLotteryNum : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<NumDataClass>
    lateinit var numlist: Array<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySearchBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_back = binding.back

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //아이템 간 간격
        recyclerView.addItemDecoration(SpaceItemDecoration(20))

        lifecycleScope.launch{
            val result = doTask()
        }

        btn_back.setOnClickListener {
            finish()
        }

    }

    //https://min-wachya.tistory.com/131#google_vignette
    //로또 사이트 크롤링
    suspend fun doTask() = withContext(Dispatchers.IO){
        var currentNumTitle: String = ""
        val url = "https://www.dhlottery.co.kr/lt645/selectPstLt645InfoNew.do?srchDir=older&srchCursorLtEpsd=1216&_=1779764626158"
        var itemList: ArrayList<NumDataClass> = arrayListOf()
        Single.fromCallable {
            try {
                val doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                    .execute()
                    .body()
                Log.d("CRAWL_API", "추출된 데이터: $doc")
                val jsonObject = JSONObject(doc)
                val num1 = jsonObject.getString("data")


                /*var num2 = elem.select("result-ball num-1n").text()
                        var num3 = elem.select("result-ball num-1n").text()
                        var num4 = elem.select("result-ball num-2n").text()
                        var num5 = elem.select("result-ball num-2n").text()
                        var num6 = elem.select("result-ball num-3n").text()
                        var bonusNum = elem.select("result-ball num-0n").text()
                        */
                var item = NumDataClass("1200", num1)
                itemList.add(item)

            } catch (e: Exception) { e.printStackTrace() }

            return@fromCallable currentNumTitle
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { text ->
                    recyclerView.adapter = AdapterClass(itemList)
                },
                {it.printStackTrace()})

                }
            }