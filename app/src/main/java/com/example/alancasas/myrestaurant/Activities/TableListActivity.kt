package com.example.alancasas.myrestaurant.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alancasas.myrestaurant.Fragments.TableListFragment
import com.example.alancasas.myrestaurant.Models.Tables
import com.example.alancasas.myrestaurant.R

class TableListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_list)

        if (findViewById<View>(R.id.activity_detail_frame) != null) {
            if (fragmentManager.findFragmentById(R.id.activity_detail_frame) == null) {
                val fragment = TableListFragment.newInstance(Tables())
                fragmentManager.beginTransaction()
                        .add(R.id.activity_detail_frame, fragment)
                        .commit()
            }
        }
    }
}
