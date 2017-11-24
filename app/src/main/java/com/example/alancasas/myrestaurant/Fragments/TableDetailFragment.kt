package com.example.alancasas.myrestaurant.Fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.Models.Tables
import com.example.alancasas.myrestaurant.R
import kotlinx.android.synthetic.main.activity_table_detail.view.*


class TableDetailFragment : Fragment(){

    var table : Table? = null

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null){
            table = arguments.getSerializable(ARG_TABLES_LIST) as Table
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater?.inflate(R.layout.fragment_table_detail, container, false)
        // TODO: Pasar todos los valores a la mesa
        val tableName: TextView = rootView!!.findViewById(R.id.table_detail_name)
        tableName.text = "Mesa ${table?.numberTable}"

        return rootView
    }


}