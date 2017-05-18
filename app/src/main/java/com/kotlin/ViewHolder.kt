package com.kotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by Administrator on 2017/5/18.
 */

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal var textView: TextView

    init {
        textView = itemView.findViewById(R.id.item_tv) as TextView
    }
}
