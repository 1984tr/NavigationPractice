package com.tr1984.navigationpractice.sign

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tr1984.navigationpractice.R
import com.tr1984.navigationpractice.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSignInBinding.inflate(inflater)
            .apply {
                val id = arguments?.getString("userId") ?: "unknown"
                userId.text = id
                signIn.setOnClickListener {
                    val action = SignInFragmentDirections.actionSignInFragmentToSignCompleteFragment(id)
                    findNavController().navigate(action)
                }
            }.root
    }
}