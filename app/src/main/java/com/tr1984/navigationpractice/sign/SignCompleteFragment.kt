package com.tr1984.navigationpractice.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tr1984.navigationpractice.R
import com.tr1984.navigationpractice.databinding.FragmentSignCompleteBinding

class SignCompleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback { navigateToDisplay() }
        return FragmentSignCompleteBinding.inflate(inflater).apply {
            userId.text = arguments?.getString("userId") ?: "unknown"
            welcome.setOnClickListener { navigateToDisplay() }
        }.root
    }

    private fun navigateToDisplay() {
        findNavController().navigate(R.id.action_signCompleteFragment_to_nav_display)
    }
}