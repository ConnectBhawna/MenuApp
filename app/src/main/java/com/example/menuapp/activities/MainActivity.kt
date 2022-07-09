package com.example.menuapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menuapp.R
import com.example.menuapp.adapters.MenuCardAdaptor
import com.example.menuapp.adapters.MenuData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val menuData = arrayOf(
            MenuData(
                "Margherita Pizza",
                "A hugely popular margherita, with a deliciously tangy single cheese topping.",
                "Rs. 129",
                R.drawable.margherit
            ),
            MenuData(
                "Double Cheese Margherita Pizza",
                "The ever-popular Margherita loaded with extra cheese.",
                "Rs. 239",
                R.drawable.doublecheesemargherita
            ),
            MenuData(
                "Farm House Pizza",
                "A pizza that goes ballistic on veggies! Overloaded with crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes.",
                "Rs. 399",
                R.drawable.farmhouse
            ),
            MenuData(
                "Peppy Paneer Pizza",
                "Chunky paneer with crisp capsicum and spicy red pepper.",
                "Rs. 479",
                R.drawable.peppypaneer
            ),
            MenuData(
                "Mexican Green Wave Pizza",
                "Loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with exotic Mexican herbs.",
                "Rs. 629",
                R.drawable.mexicangreenwave
            ),
            MenuData(
                "Veg Extravaganza Pizza",
                "Overloaded with corn, black olives, onions, capsicum, mushrooms, tomatoes, jalapeno and extra cheese.",
                "Rs. 799",
                R.drawable.vegextravaganz
            ),
            MenuData(
                "Indi Tandoori Pizza",
                "It is hot. It is spicy. It is oh-so-Indian. Tandoori paneer with capsicum, red paprika, mint & mayo.",
                "Rs. 900",
                R.drawable.indiantandooripaneer

            )
        )
        val menuCardAdaptor = MenuCardAdaptor(menuData,this@MainActivity)
        recyclerView.adapter = menuCardAdaptor
    }
}
