package com.example.alancasas.myrestaurant.Fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.TextView
import com.example.alancasas.myrestaurant.Adapters.MyDishesTableDetailAdapter
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.Models.Tables
import com.example.alancasas.myrestaurant.R
import kotlinx.android.synthetic.main.activity_table_detail.view.*


class TableDetailFragment : Fragment(){

    private lateinit var rootView : View
    var dishAmountCounter = 0

    companion object {
        private val ARG_TABLES_LIST = "ARG_TABLES_LIST"

        fun newInstance(table: Table) : TableDetailFragment{
            val fragment = TableDetailFragment()
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLES_LIST, table)
            fragment.arguments = arguments
            return fragment
        }
    }

    var table:Table? = null
        set(value) {
            if (value != null){
                val tableName: TextView = rootView.findViewById(R.id.table_detail_name)
                val billCount: TextView = rootView.findViewById(R.id.bill_count)
                val dishList : ListView = rootView.findViewById(R.id.count_list_detail)

                var dishesArray = Dishes().dishListToArray()
                val adapter = MyDishesTableDetailAdapter(dishesArray,R.layout.list_dishes_count, activity)
                dishList.adapter = adapter

                tableName.text = "Mesa ${value.numberTable}"
                billCount.text = "${value.billTable}"
            }
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        inflater?.let {
            rootView = inflater.inflate(R.layout.fragment_table_detail, container, false)
            if (arguments != null){
                table = arguments.getSerializable(ARG_TABLES_LIST) as Table
            }
        }
        return rootView
    }

}






















