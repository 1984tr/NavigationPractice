package com.tr1984.navigationpractice.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tr1984.navigationpractice.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentSignUpBinding.inflate(inflater).apply {
            signUp.setOnClickListener {
                val action = SignUpFragmentDirections.actionSignUpFragmentToSignCompleteFragment("userBySignUp")
                findNavController().navigate(action)
            }
        }.root
    }
}