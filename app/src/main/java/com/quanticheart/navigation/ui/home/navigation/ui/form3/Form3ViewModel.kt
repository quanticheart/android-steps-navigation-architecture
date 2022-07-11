package com.quanticheart.navigation.ui.home.navigation.ui.form3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quanticheart.navigation.NavApplication
import com.quanticheart.navigation.repository.FormRegister
import com.quanticheart.navigation.repository.FormRepository

class Form3ViewModel : ViewModel() {

    private val repository by lazy { FormRepository(NavApplication.appContext) }

    private val _details = MutableLiveData<FormRegister>()
    val details = _details

    fun getData() {
        _details.value = repository.getForm()
    }
}