package com.tr1984.navigationpractice.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tr1984.navigationpractice.databinding.FragmentConfirmDialogBinding

class ConfirmDialogFragment : BottomSheetDialogFragment() {

    private val args: ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentConfirmDialogBinding.inflate(inflater).apply {
            message.text = args.message
            no.setOnClickListener {
                findNavController().run {
                    previousBackStackEntry?.savedStateHandle?.set("confirm", false)
                    popBackStack()
                }
            }
            yes.setOnClickListener {
                findNavController().run {
                    previousBackStackEntry?.savedStateHandle?.set("confirm", true)
                    popBackStack()
                }
            }
        }.root
    }
}