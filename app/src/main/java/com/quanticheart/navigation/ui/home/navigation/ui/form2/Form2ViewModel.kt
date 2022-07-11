package com.quanticheart.navigation.ui.home.navigation.ui.form2

import androidx.lifecycle.ViewModel
import com.quanticheart.navigation.NavApplication
import com.quanticheart.navigation.repository.FormRepository

class Form2ViewModel : ViewModel() {

    private val repository by lazy { FormRepository(NavApplication.appContext) }

    fun setDoc(doc: String) {
        repository.saveDoc(doc)
    }
}