package com.tr1984.navigationpractice.nested

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tr1984.navigationpractice.databinding.FragmentNestedFirstBinding

class NestedFirstFragment : Fragment() {

    private val args: NestedFirstFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentNestedFirstBinding.inflate(inflater).apply {
            argument.text = args.nested
            next.setOnClickListener {
                val action = NestedFirstFragmentDirections.actionNestedFirstFragmentToNestedSecondFragment(args.nested)
                findNavController().navigate(action)
            }
        }.root
    }
}