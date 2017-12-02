package com.example.alancasas.myrestaurant.Fragments

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alancasas.myrestaurant.Activities.DishDetailActivity
import com.example.alancasas.myrestaurant.Adapters.MyDishesListAdapter
import com.example.alancasas.myrestaurant.Interfaces.CustomDishOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.R

class DishListFragment : Fragment(){

    private lateinit var recyclerView : RecyclerView
    private lateinit var layoutManager : RecyclerView.LayoutManager
    private lateinit var adapter : MyDishesListAdapter

    private lateinit var rootView: View

    companion object {
        private val ARG_DISH = "ARG_DISH"
        fun newDishInstance(dishes: Dishes): DishListFragment {
            val fragment = DishListFragment()
            val arguments = Bundle()
            arguments.putSerializable(ARG_DISH,dishes)
            fragment.arguments = arguments
            return fragment
        }
    }

    private var dishes: Dishes? = null
        set(value) {
            if (value != null){
                recyclerView = rootView.findViewById(R.id.dish_recycler_view)

                layoutManager = LinearLayoutManager(activity)

                adapter = MyDishesListAdapter(value,R.layout.recycler_view_list_dish, object : CustomDishOnItemClickListener{
                    override fun onCustomDishOnItemClickListener(dish: Dish, position: Int) {
                        val intent = Intent(activity, DishDetailActivity::class.java)
                        intent.putExtra(DishListFragment.ARG_DISH, value[position])
                        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT)
                        startActivity(intent)
                        activity.finish()
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
            rootView = it.inflate(R.layout.fragment_dish_list, container, false)
            if (arguments != null){
                dishes = arguments.getSerializable(ARG_DISH) as Dishes
            }
        }

        return rootView
    }

}




























