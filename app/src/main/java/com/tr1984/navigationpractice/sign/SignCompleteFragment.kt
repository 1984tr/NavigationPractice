package com.tr1984.navigationpractice.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tr1984.navigationpractice.databinding.FragmentSignCompleteBinding

class SignCompleteFragment : Fragment() {

    private val args: SignCompleteFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback { navigateToMain() }
        return FragmentSignCompleteBinding.inflate(inflater).apply {
            userId.text = args.userId
            welcome.setOnClickListener { navigateToMain() }
        }.root
    }

    private fun navigateToMain() {
        activity?.finish()
    }
}