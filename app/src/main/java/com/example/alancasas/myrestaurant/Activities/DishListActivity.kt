package com.example.alancasas.myrestaurant.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alancasas.myrestaurant.Fragments.DishDetailFragment
import com.example.alancasas.myrestaurant.Fragments.DishListFragment
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.R

class DishListActivity : AppCompatActivity() {

    private var dishes = Dishes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)

        if (fragmentManager.findFragmentById(R.id.frame_dish_list_fragment) == null){
            val fragment = DishListFragment.newDishInstance(dishes)
            fragmentManager.beginTransaction()
                    .add(R.id.frame_dish_list_fragment, fragment)
                    .commit()
        }else{
            fragmentManager.beginTransaction()
                    .remove(fragmentManager.findFragmentById(R.id.frame_dish_list_fragment))
                    .commit()
        }
    }
}
