package com.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * Created by Administrator on 2016/12/1.
 */

abstract class BaseRecycleViewAdapter<T, K : BaseRecycleViewHolder>(var mContext: Context, internal var layoutId: Int, var mData: List<T>?) : RecyclerView.Adapter<K>() {
    internal var inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): K {

        val view = inflater.inflate(layoutId, parent, false)
        return BaseRecycleViewHolder(view) as K
    }


    abstract fun onBdViewHolder(`object`: K, position: Int)

    override fun onBindViewHolder(holder: K, position: Int) {
        onBdViewHolder(holder as K, position)
    }

    override fun getItemCount(): Int {
        if (mData == null && mData!!.size == 0)
            return 0
        else
            return mData!!.size
    }
}
