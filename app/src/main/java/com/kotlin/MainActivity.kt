package com.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerAdapter.iTemClick {
    override fun itemClick(position: Int) {
        Log.v("wamgmo,a ", "dawdawda")
    }

    var adapter: RecyclerAdapter? = null
    internal var mData: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test_tv.text = "你大爷的hello world"
        test_btn.setOnClickListener {
            var mList:ArrayList<String> = ArrayList<String>()
            for (i in 1..50){
                mList.add("新加数据"+i)
            }
            adapter!!.addNewData(mList)

        }
        initData()
        adapter = RecyclerAdapter(this, mData!!)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter!!.setITemClick(this)

    }

    private fun initData() {
        mData = ArrayList<String>()
        for (i in 1..20) {
            mData!!.add("woshi shuj " + i)
        }
    }


    fun initView(savedInstanceState: Bundle?) {
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
