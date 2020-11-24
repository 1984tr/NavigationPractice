package com.tr1984.navigationpractice.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tr1984.navigationpractice.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private val args: SignInFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentSignInBinding.inflate(inflater)
                .apply {
                    val id = args.userId
                    userId.text = id
                    signIn.setOnClickListener {
                        val action = SignInFragmentDirections.actionSignInFragmentToSignCompleteFragment(id)
                        findNavController().navigate(action)
                    }
                }.root
    }
}