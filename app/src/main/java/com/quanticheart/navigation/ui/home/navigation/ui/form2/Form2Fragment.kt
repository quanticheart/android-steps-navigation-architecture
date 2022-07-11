package com.quanticheart.navigation.ui.home.navigation.ui.form2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.quanticheart.navigation.databinding.FragmentForm2Binding

class Form2Fragment : Fragment() {

    private var _binding: FragmentForm2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this)[Form2ViewModel::class.java]

        _binding = FragmentForm2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.doc.addTextChangedListener { text ->
            text?.toString()?.let {
                viewModel.setDoc(it)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}