package com.example.alancasas.myrestaurant.Fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.alancasas.myrestaurant.Adapters.MyDishesListAdapter
import com.example.alancasas.myrestaurant.Interfaces.CustomDishOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.R

/**
 * Created by alancasas on 25/11/17.
 */
class DishListFragment : Fragment(){

    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var adapter : MyDishesListAdapter
    var dishes = Dishes().dishListToArray()

    private lateinit var rootView: View

    companion object {
        private val ARG_DISH = "ARG_DISH"
        fun newDishInstance(): DishListFragment = DishListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let {
            rootView = it.inflate(R.layout.fragment_dish_list, container, false)
        }

        recyclerView = rootView.findViewById(R.id.dish_recycler_view)

        layoutManager = LinearLayoutManager(activity)

        adapter = MyDishesListAdapter(dishes,R.layout.recycler_view_list_dish, object : CustomDishOnItemClickListener{
            override fun onCustomDishOnItemClickListener(dish: Dish, position: Int) {
                // TODO: tenemos que navegar a la pantalla detalle del plato para poder agregarlo.
                Toast.makeText(activity,"Tenemos que implementar navegacion a siguiente pantalla algo", Toast.LENGTH_LONG).show()
            }
        })

        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        return rootView
    }

}




























