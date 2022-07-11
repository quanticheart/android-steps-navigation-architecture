package com.quanticheart.navigation.ui.home.navigation.ui.form3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.quanticheart.navigation.databinding.FragmentForm3Binding
import com.quanticheart.navigation.ui.home.navigation.FormActivity

class Form3Fragment : Fragment() {

    private var _binding: FragmentForm3Binding? = null

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

        _binding = FragmentForm3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.run {
            details.observe(viewLifecycleOwner) {
                it?.let {
                    binding.name.text = it.name
                    binding.cel.text = it.cel
                    binding.email.text = it.email
                    binding.doc.text = it.doc ?: "Not Document"
                }
            }
            getData()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}