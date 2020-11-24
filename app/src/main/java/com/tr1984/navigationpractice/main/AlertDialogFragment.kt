package com.tr1984.navigationpractice.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tr1984.navigationpractice.databinding.FragmentAlertDialogBinding

class AlertDialogFragment : BottomSheetDialogFragment() {

    private val args: AlertDialogFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentAlertDialogBinding.inflate(inflater).apply {
            message.text = args.message
            close.setOnClickListener { findNavController().popBackStack() }
        }.root
    }
}