package com.example.alancasas.myrestaurant.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.alancasas.myrestaurant.Fragments.TableDetailFragment
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.Models.Tables
import com.example.alancasas.myrestaurant.R

class TableDetailActivity : AppCompatActivity() {

    private var defaultTable = Tables()[0]

    companion object {
        val EXTRA_TABLE = "EXTRA_TABLE"

        fun intent (context: Context, table: Table) : Intent{
            val intent = Intent(context, TableDetailActivity::class.java)
            intent.putExtra(EXTRA_TABLE, table)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        var table = intent.getSerializableExtra(EXTRA_TABLE) as? Table
        if (table != null){
            defaultTable = table
        }

        if (fragmentManager.findFragmentById(R.id.frame_fragment_table_detail) == null) {
            val tableDetailFragment = TableDetailFragment.newInstance(defaultTable)
            fragmentManager.beginTransaction()
                    .add(R.id.frame_fragment_table_detail, tableDetailFragment)
                    .commit()
        }
    }
}
