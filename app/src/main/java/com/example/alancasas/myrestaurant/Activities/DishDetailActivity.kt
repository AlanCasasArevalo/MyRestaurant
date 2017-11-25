package com.example.alancasas.myrestaurant.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alancasas.myrestaurant.Fragments.DishDetailFragment
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.R

class DishDetailActivity : AppCompatActivity() {

    lateinit var dish: Dish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)

        dish = intent.getSerializableExtra("ARG_DISH") as Dish

        if (fragmentManager.findFragmentById(R.id.frame_fragment_dish_detail) == null){
            fragmentManager.beginTransaction()
                    .add(R.id.frame_fragment_dish_detail, DishDetailFragment.newInstance(dish))
                    .commit()
        }

    }
}
