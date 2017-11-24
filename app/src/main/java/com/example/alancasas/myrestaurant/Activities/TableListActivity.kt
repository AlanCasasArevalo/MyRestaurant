package com.example.alancasas.myrestaurant.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.example.alancasas.myrestaurant.Adapters.MyTableAdapter
import com.example.alancasas.myrestaurant.Fragments.TableListFragment
import com.example.alancasas.myrestaurant.Interfaces.CustomTableOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.R

class TableListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_list)

        if (fragmentManager.findFragmentById(R.id.frame_table_list_fragment) == null){
            val fragment = TableListFragment.newInstance()
            fragmentManager.beginTransaction()
                    .add(R.id.frame_table_list_fragment, fragment)
                    .commit()
        }

    }

}
