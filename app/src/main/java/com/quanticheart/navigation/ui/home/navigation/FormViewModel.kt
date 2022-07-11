package com.quanticheart.navigation.ui.home.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quanticheart.navigation.NavApplication
import com.quanticheart.navigation.repository.FormRepository
import com.quanticheart.navigation.ui.home.navigation.constants.stepData
import com.quanticheart.navigation.ui.home.navigation.constants.stepResume
import com.quanticheart.navigation.ui.home.navigation.constants.stepThankYou

class FormViewModel : ViewModel() {

    private val repository = FormRepository(NavApplication.appContext)

    private val _step = MutableLiveData<Int>().apply { value = 1 }
    val step: LiveData<Int> = _step

    private val _send = MutableLiveData<Boolean>()
    val send = _send

    fun nextStep(step: Int? = null) {
        when (step) {
            stepThankYou -> _step.value = step
            else -> {
                if (_step.value == stepResume) {
                    sendData()
                } else {
                    val validatedStep = step ?: _step.value!!.plus(1)
                    if (validateNextStep(validatedStep)) {
                        _step.value = validatedStep
                    }
                }
            }
        }
    }

    fun backStep(step: Int? = null) {
        val validatedStep = if (_step.value == stepResume) {
            if (repository.getForm().doc == null) {
                stepData
            } else step ?: _step.value!!.minus(1)
        } else {
            step ?: _step.value!!.minus(1)
        }
        if (validateNextStep(validatedStep)) {
            _step.value = validatedStep
        }
    }

    private fun validateNextStep(step: Int) = _step.value != step

    fun sendData() {
        _send.value = repository.sendRegister()
    }

    fun finishForm() {
        repository.removeData()
    }
}