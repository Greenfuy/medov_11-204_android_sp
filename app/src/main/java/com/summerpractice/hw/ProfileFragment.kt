package com.summerpractice.hw

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.summerpractice.hw.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)

        binding?.run {
            btnToLogIn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_profileFragment_to_anotherFragment,
                AnotherFragment.createBundle("Profile")
                )
            }

            btnToSignUp.setOnClickListener {
                findNavController().navigate(
                    R.id.action_profileFragment_to_anotherFragment,
                    AnotherFragment.createBundle("Profile")
                    )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

