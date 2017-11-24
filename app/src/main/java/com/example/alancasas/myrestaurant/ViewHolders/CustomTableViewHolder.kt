package com.example.alancasas.myrestaurant.ViewHolders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.alancasas.myrestaurant.Interfaces.CustomTableOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.R
import kotlinx.android.synthetic.main.recycler_view_list_table.view.*

class CustomTableViewHolder (itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {

    var tableNumber :TextView = itemView.findViewById(R.id.table_number)
    var context = context

    fun bin (table: Table, listener: CustomTableOnItemClickListener){
        tableNumber.text = "Mesa ${table.numberTable}"

        itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                listener.onCustomTableOnItemClickListener(table, adapterPosition)
            }
        })
    }
}