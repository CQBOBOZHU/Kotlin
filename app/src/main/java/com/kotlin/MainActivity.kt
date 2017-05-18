package com.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var recycler: RecyclerAdapter? = null
    internal var mData: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test_tv.text = "你大爷的hello world"
        test_btn.setOnClickListener { test_tv.text = "你二大爷的hello world" }
        initData()
        recycler = RecyclerAdapter(this, mData!!)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = recycler

    }

    private fun initData() {
        mData = ArrayList<String>()
        for (i in 1..20) {
            mData!!.add("woshi shuj " + i)
        }
    }


    fun initView(savedInstanceState: Bundle?) {
        Toast.makeText(this, "adada", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
