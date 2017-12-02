package com.example.alancasas.myrestaurant.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alancasas.myrestaurant.Fragments.TableListFragment
import com.example.alancasas.myrestaurant.Models.Tables
import com.example.alancasas.myrestaurant.R

class TableListActivity : AppCompatActivity() {

    val tables = Tables()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_list)

        if (fragmentManager.findFragmentById(R.id.frame_table_list_fragment) == null){
            val fragment = TableListFragment.newInstance(tables)
            fragmentManager.beginTransaction()
                    .add(R.id.frame_table_list_fragment, fragment)
                    .commit()
        }

    }

}
