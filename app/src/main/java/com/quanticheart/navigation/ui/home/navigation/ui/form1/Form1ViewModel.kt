package com.quanticheart.navigation.ui.home.navigation.ui.form1

import androidx.lifecycle.ViewModel
import com.quanticheart.navigation.NavApplication
import com.quanticheart.navigation.repository.FormRepository

class Form1ViewModel : ViewModel() {

    private val repository by lazy { FormRepository(NavApplication.appContext) }

    fun setName(name: String) {
        repository.saveName(name)
    }

    fun setCel(cel: String) {
        repository.saveCel(cel)
    }

    fun setEmail(email: String) {
        repository.saveEmail(email)
    }
}