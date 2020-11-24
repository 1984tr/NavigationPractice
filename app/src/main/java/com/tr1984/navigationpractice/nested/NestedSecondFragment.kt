package com.tr1984.navigationpractice.nested

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tr1984.navigationpractice.R
import com.tr1984.navigationpractice.databinding.FragmentNestedSecondBinding

class NestedSecondFragment : Fragment() {

    private val args: NestedSecondFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback { navigateToDisplay() }
        return FragmentNestedSecondBinding.inflate(inflater).apply {
            argument.text = args.nested
            done.setOnClickListener { navigateToDisplay() }
        }.root
    }

    private fun navigateToDisplay() {
        findNavController().popBackStack(R.id.homeFragment, false)
    }
}