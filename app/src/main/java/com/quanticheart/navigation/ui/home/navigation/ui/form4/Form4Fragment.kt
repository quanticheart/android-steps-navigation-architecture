package com.quanticheart.navigation.ui.home.navigation.ui.form4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.quanticheart.navigation.databinding.FragmentForm4Binding
import com.quanticheart.navigation.ui.home.navigation.FormActivity
import com.quanticheart.navigation.ui.home.navigation.ui.form3.Form3ViewModel

class Form4Fragment : Fragment() {

    private var _binding: FragmentForm4Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this)[Form3ViewModel::class.java]

        _binding = FragmentForm4Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btn.setOnClickListener {
            FormActivity.nextStep()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}