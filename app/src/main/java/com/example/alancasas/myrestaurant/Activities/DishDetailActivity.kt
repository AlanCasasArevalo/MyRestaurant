package com.example.alancasas.myrestaurant.Activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alancasas.myrestaurant.Fragments.DishDetailFragment
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.R

class DishDetailActivity : AppCompatActivity() {

    private var dishDefault = Dishes()[0]

    companion object {
        val EXTRA_DISH = "EXTRA_DISH"

        fun intent (context: Context, dish: Dish?) : Intent {
            val intent = Intent(context, DishDetailActivity::class.java)
            intent.putExtra(EXTRA_DISH, dish)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)

        var dish = intent.getSerializableExtra(EXTRA_DISH)

        if (dish != null){
            dishDefault = dish as Dish
        }

        if (fragmentManager.findFragmentById(R.id.frame_fragment_dish_detail) == null){
            fragmentManager.beginTransaction()
                    .add(R.id.frame_fragment_dish_detail, DishDetailFragment.newInstance(dishDefault))
                    .commit()
        }

    }
}
