package com.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import java.util.ArrayList

/**
 * Created by Administrator on 2017/5/18.
 */

class RecyclerAdapter(internal var context: Context, internal var mData: List<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mData[position]
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}
