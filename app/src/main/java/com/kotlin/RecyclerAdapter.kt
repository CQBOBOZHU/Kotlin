package com.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


/**
 * Created by Administrator on 2017/5/18.
 */

class RecyclerAdapter(internal var context: Context, internal var mData: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mData[position]
        holder.itemView.setOnClickListener {
            itemClick!!.itemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    var itemClick: iTemClick? = null

    fun setITemClick(itemClick: iTemClick) {
        this.itemClick = itemClick
    }

    fun addNewData(mList:List<String>){
        for (i in 0..mList.size-1){
            mData!!.add(mList.get(i))
            notifyItemInserted(itemCount)
        }
    }

    interface iTemClick {
        fun itemClick(position: Int)
    }
}
