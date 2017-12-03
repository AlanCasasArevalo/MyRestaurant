package com.example.alancasas.myrestaurant.Fragments

import android.app.AlertDialog
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.alancasas.myrestaurant.Activities.DishDetailActivity
import com.example.alancasas.myrestaurant.Adapters.MyDishesListAdapter
import com.example.alancasas.myrestaurant.Interfaces.CustomDishOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.R
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.json.JSONObject
import java.net.URL
import java.util.*

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

                updateDish()

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


    fun updateDish (){

        async(UI){
            val newDish : Deferred<Dishes?> = bg {
                downloadDishes()
            }

            if (newDish.await() == null){
                AlertDialog.Builder(activity)
                        .setTitle("Error")
                        .setMessage("No se pudo descargar la lista de los platos")
                        .setPositiveButton("Reintentar", {
                            _,_ -> updateDish()
                        })
                        .setNegativeButton("Salir", {_, _ -> activity.finish()})
                        .show()
            }else{
                dishes = newDish.await()
            }
        }

    }

    fun downloadDishes(): Dishes? {
        try {

            var dishImage:ImageView? = null

            // Nos descargamos la información del tiempo a machete
            val url = URL("http://www.mocky.io/v2/5a23118c2f0000b6125ec685")
            val jsonString = Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next()
            val jsonRoot = JSONObject(jsonString.toString())
            val dishArray = jsonRoot.getJSONArray("dishes")

            val dishes = mutableListOf<Dish>()

            for (dishIndex in 0 until dishArray.length()) {
                val dish = dishArray.getJSONObject(dishIndex)
                val name = dish.getString("foodName")
                val price = dish.getDouble("foodPrice")
                val cookTime = dish.getInt("foodCookTime")
                val description = dish.getString("foodDescription")
                var iconString = dish.getString("foodImage")


                // TODO: Revisar la carga de los platos desde internet.

                iconString = iconString.substring(0, iconString.length -1)
                val imageInt = Integer.parseInt(iconString)
                val iconResource = when(imageInt){
                    2 -> R.drawable.berenjenas
                    3 -> R.drawable.cuscus
                    4 -> R.drawable.lomo
                    5 -> R.drawable.tarta_manzana
                    6 -> R.drawable.helado_chocolate
                    else -> R.drawable.aceituna
                }


                dishes.add(Dish(name,description,iconResource,price,1,cookTime,null, null))
            }

            Thread.sleep(1000)

            return dishes as? Dishes
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return null
    }


}




























