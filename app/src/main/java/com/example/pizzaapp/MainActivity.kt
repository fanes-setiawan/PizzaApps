package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.adapter.MenuAdapter
import com.example.pizzaapp.database.DatabaseHelper

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAddMenu: Button
    private lateinit var recyclerViewMenu: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAddMenu = findViewById(R.id.buttonAddMenu)
        recyclerViewMenu = findViewById(R.id.recyclerViewMenu)

        buttonAddMenu.setOnClickListener {
            val intent = Intent(this, AddMenuActivity::class.java)
            startActivity(intent)
        }

        db = DatabaseHelper(this)
        recyclerViewMenu.layoutManager = LinearLayoutManager(this)
        menuAdapter = MenuAdapter(emptyList())
        recyclerViewMenu.adapter = menuAdapter

        loadMenuData()
    }

    override fun onResume() {
        super.onResume()
        loadMenuData()
    }

    private fun loadMenuData() {
        val menuList = db.getAllMenus()
        menuAdapter.setMenuList(menuList)
    }
}