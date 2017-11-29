package com.example.alancasas.myrestaurant.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.alancasas.myrestaurant.Fragments.TableDetailFragment
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.R

class TableDetailActivity : AppCompatActivity() {

    lateinit var table: Table

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        table = intent.getSerializableExtra("ARG_TABLE") as Table

        if (fragmentManager.findFragmentById(R.id.frame_fragment_table_detail) == null) {
            val tableDetailFragment = TableDetailFragment.newInstance(table)
            fragmentManager.beginTransaction()
                    .add(R.id.frame_fragment_table_detail, tableDetailFragment)
                    .commit()
        }
    }



}
