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

    private lateinit var recyclerView : RecyclerView
    private lateinit var layoutManager : RecyclerView.LayoutManager
    private lateinit var adapter: MyTableListAdapter

    private lateinit var rootView: View

    companion object {
        private val ARG_TABLE = "ARG_TABLE"

        fun newInstance (tables: Tables) : TableListFragment {
            val fragment = TableListFragment()
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLE, tables)
            fragment.arguments = arguments
            return fragment
        }
    }

    private var tables: Tables? = null
        set(value) {
            if (value != null){
                recyclerView = rootView.findViewById(R.id.recycler_view)
                layoutManager = LinearLayoutManager(activity)

                adapter = MyTableListAdapter(value.tablesListToArray(), R.layout.recycler_view_list_table, object : CustomTableOnItemClickListener {
                    override fun onCustomTableOnItemClickListener(table: Table, position: Int) {
                        val intent = TableDetailActivity.intent(activity, value[position])
                        startActivity(intent)
                    }
                })

                recyclerView.setHasFixedSize(true)
                recyclerView.itemAnimator = DefaultItemAnimator()
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let {
            rootView = it.inflate(R.layout.fragment_table_list, container, false)
            if (arguments != null){
                tables = arguments.getSerializable(ARG_TABLE) as Tables
            }
        }

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


    // TODO: Debuggear el numero que sale por defecto de una tabla nueva
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == R.id.add_name){
            addNewElement(0)
            true
        }else{
            super.onOptionsItemSelected(item)
        }
    }

    private fun addNewElement (position: Int ){
        var tableCounter = tables?.count ?: 0
        tables?.addNewTable(position, Table( tableCounter++, null, 0.0))
        adapter.notifyItemInserted(position)
        layoutManager.scrollToPosition(position)
    }

}