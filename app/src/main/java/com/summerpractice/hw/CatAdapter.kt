package com.summerpractice.hw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.summerpractice.hw.databinding.ItemCatBinding

class CatAdapter(
    private var list: List<Cat>,
    private val glide: RequestManager,
    private val onItemClick: (Cat) -> Unit,
) : RecyclerView.Adapter<CatItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatItem = CatItem(
        binding = ItemCatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick,
    )

    override fun onBindViewHolder(holder: CatItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(newList: List<Cat>) {
        list = newList
        notifyDataSetChanged()
    }

    fun getItem(position: Int?) : Cat? {
        if (position == null) return null
        return list[position]
    }
}