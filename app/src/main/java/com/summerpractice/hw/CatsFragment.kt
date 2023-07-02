package com.summerpractice.hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.summerpractice.hw.databinding.FragmentCatsBinding

class CatsFragment : Fragment(R.layout.fragment_cats) {
    private var binding: FragmentCatsBinding? = null
    private var adapter: CatAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCatsBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = CatAdapter(
            list = CatRepository.list,
            glide = Glide.with(this)
        ) { cat ->
            findNavController().navigate(R.id.action_catsFragment_to_catPageFragment,
                CatPageFragment.createBundle(cat.id))
        }
        binding?.rvCats?.adapter = adapter
    }
}