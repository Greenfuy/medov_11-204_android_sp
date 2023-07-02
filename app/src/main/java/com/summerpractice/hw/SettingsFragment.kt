package com.summerpractice.hw

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.summerpractice.hw.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSettingsBinding.bind(view)

        binding?.run {
            btnToGeneral.setOnClickListener {
                findNavController().navigate(R.id.action_settingsFragment_to_anotherFragment)
                Snackbar.make(root, "Settings", Snackbar.LENGTH_LONG).show()
            }

            btnToHistory.setOnClickListener {
                findNavController().navigate(R.id.action_settingsFragment_to_anotherFragment)
                Snackbar.make(root, "Settings", Snackbar.LENGTH_LONG).show()
            }

            btnToAboutUs.setOnClickListener {
                findNavController().navigate(R.id.action_settingsFragment_to_anotherFragment)
                Snackbar.make(root, "Settings", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

