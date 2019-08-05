package com.example.test

import android.content.Context
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>{
    interface Listener{
        fun onItemClick(item: Item)
    }

    val context : Context
    val itemList : List<Item>
    val listener : Listener
    constructor(context:Context, items : List<Item>, listener : Listener){
      this.context = context
        this.itemList = items
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val item = itemList.get(position)
        val view = holder as ItemHolder
        view.name.text = item.name

    }

    inner class ItemHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val name : TextView
        init {
            name = itemView!!.findViewById(R.id.name)
        }
    }
}