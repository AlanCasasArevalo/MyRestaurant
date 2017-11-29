package com.example.alancasas.myrestaurant.Fragments

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.alancasas.myrestaurant.Activities.DishListActivity
import com.example.alancasas.myrestaurant.Adapters.MyDishesTableDetailAdapter
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.R
import kotlinx.android.synthetic.main.fragment_table_detail.*


class TableDetailFragment : Fragment(){

    private lateinit var rootView : View
    private var dishesArray : ArrayList<Dish> = arrayListOf()
    private var tempDishArray : ArrayList<Dish> = arrayListOf()
    private var billCount = 0.0
    private var dishAdded:Dish? = null

    companion object {
        private val ARG_TABLES_LIST = "ARG_TABLES_LIST"
        val REQUEST_DISH = 13
        private val BILLCOUNT = "BILLCOUNT"

        fun newInstance(table: Table) : TableDetailFragment{
            val fragment = TableDetailFragment()
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLES_LIST, table)
            fragment.arguments = arguments
            return fragment
        }
    }

    private var table:Table? = null
        set(value) {
            if (value != null){
                val addNewDish:Button = rootView.findViewById(R.id.add_dish_to_table)
                val tableName: TextView = rootView.findViewById(R.id.table_detail_name)
                val billCountTextView: TextView = rootView.findViewById(R.id.bill_count)

                addNewDish.setOnClickListener {
                    val intent = Intent(activity, DishListActivity::class.java)
                    startActivityForResult(intent, REQUEST_DISH)
                }

                tableName.text = "Mesa ${value.numberTable}"
                billCountTextView.text = "$billCount"
            }
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let {
            rootView = inflater.inflate(R.layout.fragment_table_detail, container, false)
            if (arguments != null){
                table = arguments.getSerializable(ARG_TABLES_LIST) as Table
            }
            setAdapter()
        }

        var resetButton : Button = rootView.findViewById(R.id.reset_bill_count)
        resetButton.setOnClickListener {
            bill_count.text = "$billCount"
            reset()
        }

        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            dishAdded = data?.getSerializableExtra("ARG_DETAIL_DISH") as? Dish
            addNewDishToTable(dishAdded)
        }

    }

    private fun billTableCount(dish: Dish?){
        var tempBillCount: Double
        var pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)

        val initialValue = pref.getFloat(BILLCOUNT, 10f)
        tempBillCount = initialValue.toDouble()

        if(dish != null){
            billCount = tempBillCount + dish.price
            bill_count.text = "${billCount}"
            pref.edit().putFloat(BILLCOUNT, billCount.toFloat()).apply()
        }else{
            bill_count.text = "$tempBillCount"
        }
    }

    private fun setAdapter() {
        val dishList : ListView = rootView.findViewById(R.id.count_list_detail)
        val adapter = MyDishesTableDetailAdapter(dishesArray,R.layout.list_dishes_count, activity)
        adapter.notifyDataSetChanged()
        dishList.adapter = adapter
    }

    private fun addNewDishToTable(dish:Dish?){
        dish?.let {

//            kkkkkkkk

            var dishBoolean = dishesArray.contains(dish)

            if (dishesArray.isEmpty()){
                dishesArray.add(dish)
            }else{
                if (!dishBoolean){
                    println("Esta en el array $dishBoolean")
                }else{
                    println("No esta en el array $dishBoolean")
                    dishesArray.add(dish)
                }
            }

//
//
//
//
//
//            if (dishesArray.isEmpty()){
//                dish.amountDish++
//                billTableCount(dish)
//                dishesArray.add(dish)
//            }else {
//                for (dishIntoArray in dishesArray) {
//                    if (dishIntoArray.name == dish.name) {
//                        dishIntoArray.amountDish++
//                        billTableCount(dishIntoArray)
//                    } else {
//                        dish.amountDish++
//                        tempDishArray.add(dish)
//                        billTableCount(dish)
//                    }
//                }
//            }
//kkkkkkkkk
//            dishesArray.addAll(tempDishArray)

            setAdapter()
        }
    }

    private fun reset(){
        var pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        billCount = 0.0
        dishesArray.clear()
        tempDishArray.clear()
        pref.edit()?.putFloat(BILLCOUNT, billCount.toFloat())?.apply()
        setAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        reset()
    }

    override fun onDetach() {
        super.onDetach()
        reset()
    }

}






















