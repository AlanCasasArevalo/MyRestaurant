package com.example.alancasas.myrestaurant.Fragments

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.R
import kotlinx.android.synthetic.main.fragment_dish_detail.*
import kotlinx.android.synthetic.main.fragment_dish_detail.view.*

class DishDetailFragment :Fragment() {

    private lateinit var rootView: View

    companion object {
        private val ARG_DETAIL_DISH = "ARG_DETAIL_DISH"

        fun newInstance(dish: Dish) : DishDetailFragment{
            val fragment = DishDetailFragment()
            val arguments = Bundle()
            arguments.putSerializable(ARG_DETAIL_DISH, dish)
            fragment.arguments = arguments
            return fragment
        }

        fun intent(context:Context, dish: Dish) : Intent{
            val intent = Intent(context, DishDetailFragment::class.java)
            intent.putExtra(ARG_DETAIL_DISH, dish)
            return intent
        }

    }

    var dish: Dish? = null
        set(value){
            if (value != null){

                val dishName:TextView = rootView.findViewById(R.id.detail_dish_name)
                val dishCookTime:TextView = rootView.findViewById(R.id.detail_dish_coock_time)
                val dishImage:ImageView = rootView.findViewById(R.id.detail_dish_image)
                val dishGarnishOption1:TextView = rootView.findViewById(R.id.garnish_option1)
                val dishGarnishOption2:TextView = rootView.findViewById(R.id.garnish_option2)
                val dishGarnishOption3:TextView = rootView.findViewById(R.id.garnish_option3)
                val dishGarnishOption4:TextView = rootView.findViewById(R.id.garnish_option4)
                val saveButton :Button = rootView.findViewById(R.id.save_dish_button)
                val cancelButton: Button = rootView.findViewById(R.id.cancel_dish_button)

                dishName.text = value.name
                dishCookTime.text = "${value.coockTime}"
                dishImage.setImageResource(value.image)
                dishGarnishOption1.text = value.garnish!![0]
                dishGarnishOption2.text = value.garnish[1]
                dishGarnishOption3.text = value.garnish[2]
                dishGarnishOption4.text = value.garnish[3]

                saveButton.setOnClickListener {
                    saveButtonTouched(value)
                }

                cancelButton.setOnClickListener {
                    cancelButtonTouched()
                }
            }
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        inflater?.let {
            rootView = inflater.inflate(R.layout.fragment_dish_detail, container, false)
            if (arguments != null){
                dish = arguments.get(ARG_DETAIL_DISH) as Dish
            }
        }

        return rootView
    }

    private fun saveButtonTouched (dishResult: Dish) {
        val returnIntent = Intent()
        returnIntent.putExtra(ARG_DETAIL_DISH, dishResult)
        activity.setResult(Activity.RESULT_OK, returnIntent)
        activity.finish()
    }

    private fun cancelButtonTouched(){
        activity.setResult(Activity.RESULT_CANCELED)
        activity.finish()
    }

}


















