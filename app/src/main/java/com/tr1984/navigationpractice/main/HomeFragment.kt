package com.tr1984.navigationpractice.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tr1984.navigationpractice.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(inflater).apply {
            sign.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSignActivity())
            }
            nested.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToNavNested("I'm argument!")
                findNavController().navigate(action)
            }
        }.root
    }
}