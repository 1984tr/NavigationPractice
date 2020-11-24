package com.tr1984.navigationpractice.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tr1984.navigationpractice.R
import com.tr1984.navigationpractice.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentIntroBinding.inflate(inflater)
                .apply {
                    signIn.setOnClickListener {
                        val action = IntroFragmentDirections.actionIntroFragmentToSignInFragment("userBySignIn")
                        findNavController().navigate(action)
                    }
                    signUp.setOnClickListener { findNavController().navigate(R.id.action_introFragment_to_signUpFragment) }
                }.root
    }
}