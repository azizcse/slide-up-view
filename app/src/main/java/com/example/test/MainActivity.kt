package com.example.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.AbsListView

class MainActivity : AppCompatActivity() , ItemAdapter.Listener{

    lateinit var rvMian: RecyclerView
    lateinit var rvSlide: RecyclerView
    var itemList  = ArrayList<Item>()

    lateinit var adapterMain : ItemAdapter
    lateinit var adapterSlide : ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareData()
        setContentView(R.layout.activity_main)
        rvMian = findViewById(R.id.main)
        rvSlide = findViewById(R.id.slide)
        initMain()
        initSlide()
    }

    private fun initMain(){
        adapterMain = ItemAdapter(this, itemList, this)
        rvMian.adapter = adapterMain
        rvMian.layoutManager = LinearLayoutManager(this)

    }

    private fun initSlide(){
        adapterSlide = ItemAdapter(this, itemList, this)
        rvSlide.adapter = adapterMain
        rvSlide.layoutManager = LinearLayoutManager(this)
    }

    private fun prepareData() {
        for (i: Int in 1..30) {
            val model = Item("Hello "+i,System.currentTimeMillis())
            itemList.add(model)
        }
    }

    override fun onItemClick(item: Item) {

    }
}
