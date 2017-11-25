package com.example.alancasas.myrestaurant.Fragments

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import com.example.alancasas.myrestaurant.Activities.TableDetailActivity
import com.example.alancasas.myrestaurant.Adapters.MyTableListAdapter
import com.example.alancasas.myrestaurant.Interfaces.CustomTableOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.Models.Tables
import com.example.alancasas.myrestaurant.R

class TableListFragment : Fragment(){

    var tables = Tables()
    private lateinit var recyclerView : RecyclerView
    private lateinit var layoutManager : RecyclerView.LayoutManager
    private lateinit var adapter: MyTableListAdapter
    private var dishes = Dishes().dishListToArray()
    private var dish = dishes[0]

    private var tableCounter = tables.count

    private lateinit var rootView: View

    companion object {
        private val ARG_TABLE = "ARG_TABLE"

        fun newInstance () : TableListFragment = TableListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let {
            rootView = it.inflate(R.layout.fragment_table_list, container, false)
        }

        recyclerView = rootView.findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(activity)

        adapter = MyTableListAdapter(tables.tablesListToArray(), R.layout.recycler_view_list_table, object : CustomTableOnItemClickListener {
            override fun onCustomTableOnItemClickListener(table: Table, position: Int) {
                val intent = Intent(activity, TableDetailActivity::class.java)
                intent.putExtra(ARG_TABLE, tables[position])
                startActivity(intent)
            }
        })

        recyclerView.setHasFixedSize(true)

        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter

        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.table_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == R.id.add_name){
            addNewElement(0)
            true
        }else{
            super.onOptionsItemSelected(item)
        }
    }

    private fun addNewElement (position: Int ){
        tables.addNewTable(position, Table( tableCounter++, dish, 0.0))
        adapter.notifyItemInserted(position)
        layoutManager.scrollToPosition(position)
    }

}