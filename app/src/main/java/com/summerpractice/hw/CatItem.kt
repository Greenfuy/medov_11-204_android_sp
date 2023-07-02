package com.summerpractice.hw

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.summerpractice.hw.databinding.ItemCatBinding

class CatItem(
    private val binding: ItemCatBinding,
    private val glide: RequestManager,
    private val onItemClick: (Cat) -> Unit,
) : ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.ALL)

    fun onBind(cat : Cat) {
        binding.run {
            tvTitle.text = cat.name
            tvDesc.text = cat.description

            glide.load(cat.url)
                .placeholder(R.drawable.loading)
                .apply(options)
                .error(R.drawable.image_not_available)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(cat)
            }
        }
    }
}