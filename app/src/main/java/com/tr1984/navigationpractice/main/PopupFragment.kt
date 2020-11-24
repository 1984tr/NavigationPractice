package com.tr1984.navigationpractice.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.tr1984.navigationpractice.databinding.FragmentPopupBinding

class PopupFragment : Fragment() {

    private lateinit var binding: FragmentPopupBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentPopupBinding.inflate(inflater).apply {
            alert.setOnClickListener {
                showAlert("This is alert dialog!")
            }
            confirm.setOnClickListener {
                val action = PopupFragmentDirections.actionPopupFragmentToConfirmDialogFragment("This is confirm dialog!")
                findNavController().navigate(action)
            }
            confirmAsGlobal.setOnClickListener {
                val action = PopupFragmentDirections.actionGlobalConfirmDialogFragment("This is confirm dialog as global!")
                findNavController().navigate(action)
            }
        }.also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val savedStateHandle = findNavController().currentBackStackEntry?.savedStateHandle ?: return
        savedStateHandle.getLiveData<Boolean>("confirm").observe(viewLifecycleOwner) {
            binding.message.text = "confirm: $it"
        }

        arguments?.getString("alert")?.let {
            showAlert(it)
        }
    }

    private fun showAlert(message: String) {
        val action = PopupFragmentDirections.actionPopupFragmentToAlertDialogFragment(message)
        findNavController().navigate(action)
    }
}