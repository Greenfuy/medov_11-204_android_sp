package com.summerpractice.hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.summerpractice.hw.databinding.FragmentCatPageBinding


class CatPageFragment : Fragment(R.layout.fragment_cat_page) {
    private var binding: FragmentCatPageBinding? = null
    private var adapter: CatAdapter? = null
    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.ALL)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCatPageBinding.bind(view)
        adapter = CatAdapter(CatRepository.list, Glide.with(this)) {}

        val cat = adapter?.getItem(arguments?.getInt(ARG_ID))


        binding?.run {
            tvId.text = cat?.id.toString()
            tvName.text = cat?.name.toString()
            tvDesc.text = cat?.description.toString()
            Glide.with(root)
                .load(cat?.url)
                .placeholder(R.drawable.loading)
                .apply(options)
                .error(R.drawable.image_not_available)
                .into(ivImage)
            btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_catPageFragment_to_catsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"

        fun createBundle(idCat: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ID, idCat)
            return bundle
        }
    }
}