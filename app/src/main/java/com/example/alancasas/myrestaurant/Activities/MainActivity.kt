package com.example.alancasas.myrestaurant.Activities

import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.example.alancasas.myrestaurant.Adapters.MyTableAdapter
import com.example.alancasas.myrestaurant.Interfaces.CustomTableOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.R

class MainActivity : AppCompatActivity() {

    lateinit var tables: ArrayList<Table>
    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var adapter: MyTableAdapter
    var dishes = Dishes().dishListToArray()
    var dish = dishes[0]

    var tableCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tables = getAllTables()
        recyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)

        adapter = MyTableAdapter(tables, R.layout.recycler_view_list_table, object : CustomTableOnItemClickListener{
            override fun onCustomTableOnItemClickListener(table: Table, position: Int) {
                deleteElement(position)
            }
        })

        recyclerView.setHasFixedSize(true)

        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.table_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.add_name){
            addNewElement(0)
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }

    fun getAllTables() : ArrayList<Table>{
        return  arrayListOf(
                Table(tableCounter,dish,20.0)
        )

    }

    fun addNewElement ( position: Int ){
        tables.add(position,Table(++tableCounter,dish,20.0))
        adapter.notifyItemInserted(position)
        layoutManager.scrollToPosition(position)
    }

    fun deleteElement (position : Int) {
        tables.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

}
