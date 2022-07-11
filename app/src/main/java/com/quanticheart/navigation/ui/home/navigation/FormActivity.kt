package com.quanticheart.navigation.ui.home.navigation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.quanticheart.navigation.R
import com.quanticheart.navigation.databinding.ActivityFormBinding
import com.quanticheart.navigation.extentions.setBackToolbar
import com.quanticheart.navigation.ui.home.navigation.constants.stepData
import com.quanticheart.navigation.ui.home.navigation.constants.stepDocument
import com.quanticheart.navigation.ui.home.navigation.constants.stepResume
import com.quanticheart.navigation.ui.home.navigation.constants.stepThankYou

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FormViewModel::class.java]
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setBackToolbar {
            viewModel.backStep()
        }

        viewModel.run {
            step.observe(this@FormActivity) {
                step(it)
            }

            send.observe(this@FormActivity) {
                if (it) {
                    nextStep(stepThankYou)
                }
            }

            binding.back.setOnClickListener {
                backStep()
            }

            binding.next.setOnClickListener {
                nextStep()
            }
        }
    }

    private fun step(step: Int) {
        binding.stepView.go(step - 1, true)
        binding.next.text = "Next"
        when (step) {
            stepData -> {
                binding.toolbar.title = "Details"
                findNavController(R.id.nav_host_fragment_activity_form).navigate(R.id.form1Fragment)
            }
            stepDocument -> {
                binding.toolbar.title = "Document"
                findNavController(R.id.nav_host_fragment_activity_form).navigate(R.id.form2Fragment)
            }
            stepResume -> {
                binding.toolbar.title = "Resume"
                binding.next.text = "Send"
                findNavController(R.id.nav_host_fragment_activity_form).navigate(R.id.form3Fragment)
            }
            stepThankYou -> {
                binding.toolbar.title = "Thank You"
                binding.bottom.visibility = View.GONE
                findNavController(R.id.nav_host_fragment_activity_form).navigate(R.id.form4Fragment)
            }
            else -> finish()
        }
    }

    override fun onDestroy() {
        viewModel.finishForm()
        super.onDestroy()
    }

    companion object {
        private lateinit var viewModel: FormViewModel

        fun nextStep(step: Int? = null) {
            viewModel.nextStep(step)
        }

        fun backStep(step: Int? = null) {
            viewModel.backStep(step)
        }
    }
}