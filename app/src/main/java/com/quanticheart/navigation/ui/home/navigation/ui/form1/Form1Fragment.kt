package com.quanticheart.navigation.ui.home.navigation.ui.form1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.quanticheart.navigation.databinding.FragmentForm1Binding
import com.quanticheart.navigation.ui.home.navigation.FormActivity
import com.quanticheart.navigation.ui.home.navigation.constants.stepResume

class Form1Fragment : Fragment() {

    private var _binding: FragmentForm1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this)[Form1ViewModel::class.java]

        _binding = FragmentForm1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.name.addTextChangedListener { text ->
            text?.toString()?.let {
                viewModel.setName(it)
            }
        }

        binding.cel.addTextChangedListener { text ->
            text?.toString()?.let {
                viewModel.setCel(it)
            }
        }

        binding.email.addTextChangedListener { text ->
            text?.toString()?.let {
                viewModel.setEmail(it)
            }
        }

        binding.docNo.setOnClickListener {
            FormActivity.nextStep(stepResume)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}