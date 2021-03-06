package com.asafin24.shoptest.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.feature_main.R
import com.asafin24.feature_main.databinding.CategoryItemBinding
import com.asafin24.feature_main.domain.model.home.CategoryModel

class CategoryAdapter(val listener: Listener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var categoryList = mutableListOf(
        CategoryModel("Phones", R.drawable.ic_phone, true),
        CategoryModel("Computer", R.drawable.ic_computer),
        CategoryModel("Health", R.drawable.ic_health),
        CategoryModel("Books", R.drawable.ic_books)
    )

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val binding = CategoryItemBinding.bind(item)

        fun bind(category: CategoryModel, listener: Listener) {
            binding.nameCategory.text = category.nameCategory
            binding.iconCategory.setBackgroundResource(category.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(categoryList[position], listener)

        val category = categoryList[position]

        if (category.isSelected) listener.onClickCategory(holder.itemView)
        else listener.unClickCategory(holder.itemView)

        holder.itemView.setOnClickListener {
            for (i in 0 until categoryList.size) {
                categoryList[i].isSelected = false
            }
            category.isSelected = true
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCategory(categoryAddList: CategoryModel) {
        categoryList.add(categoryAddList)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClickCategory(category: View)
        fun unClickCategory(category: View)
    }
}