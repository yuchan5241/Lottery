package com.example.lottery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.parcel.Parcelize

class AdapterClass(private val dataList: ArrayList<NumDataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val item = dataList[position]
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){

        var lotteryNum: TextView = itemView.findViewById(R.id.lotteryNum)
        fun setItem(item: NumDataClass){
            lotteryNum.text = item.title + " " + item.num1 + " " + item.num2 + " " + item.num3 +
                    " " + item.num4 + " " + item.num5 + " " + item.num6 + " " + item.bonusNum


        }


    }
}