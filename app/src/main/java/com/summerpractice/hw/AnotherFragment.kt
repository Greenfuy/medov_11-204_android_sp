package com.summerpractice.hw

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.summerpractice.hw.databinding.FragmentAnotherBinding


class AnotherFragment : Fragment(R.layout.fragment_another) {

    private var binding: FragmentAnotherBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAnotherBinding.bind(view)

        binding?.run {
            val className = arguments?.getString(ARG_NAME)
            Snackbar.make(root, className.toString(), Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


    companion object {

        private const val ARG_NAME = "ARG_NAME"
        fun createBundle(name : String) : Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            return bundle
        }
    }
}

