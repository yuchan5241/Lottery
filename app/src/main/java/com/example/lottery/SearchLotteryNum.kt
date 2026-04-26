package com.example.lottery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lottery.databinding.ActivityMainBinding
import com.example.lottery.databinding.ActivitySearchBinding
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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

        doTask("https://www.dhlottery.co.kr/lt645/result")


        btn_back.setOnClickListener {
            finish()
        }

    }

    //https://min-wachya.tistory.com/131#google_vignette
    //로또 사이트 크롤링
    fun doTask(url: String){
        var currentNumTitle: String = ""
        var itemList: ArrayList<NumDataClass> = arrayListOf()

        Single.fromCallable {
            try {
                val doc = Jsoup.connect(url).get()


                val elements: Elements = doc.select("class.result-ballBox")

                run elemLoop@{
                    elements.forEachIndexed { index, elem ->
                        var num1 = elem.select("result-ball num-0n").text()
                        var num2 = elem.select("result-ball num-1n").text()
                        var num3 = elem.select("result-ball num-1n").text()
                        var num4 = elem.select("result-ball num-2n").text()
                        var num5 = elem.select("result-ball num-2n").text()
                        var num6 = elem.select("result-ball num-3n").text()
                        var bonusNum = elem.select("result-ball num-0n").text()

                        var item = NumDataClass("1200", num1, num2, num3, num4, num5, num6, bonusNum)
                        itemList.add(item)

                    }
                }

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