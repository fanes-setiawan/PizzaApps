package com.example.pizzaapp.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.model.MenuModel

class MenuAdapter(private var menuList: List<MenuModel>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewPhoto: ImageView = itemView.findViewById(R.id.imageViewPhoto)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = menuList[position]
        holder.textViewName.text = menu.name
        holder.textViewDescription.text = menu.description
        holder.textViewPrice.text = menu.price.toString()
        val bitmap = BitmapFactory.decodeByteArray(menu.image, 0, menu.image.size)
        holder.imageViewPhoto.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun setMenuList(newMenuList: List<MenuModel>) {
        menuList = newMenuList
        notifyDataSetChanged()
    }
}