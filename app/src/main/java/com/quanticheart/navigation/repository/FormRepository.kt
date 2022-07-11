package com.quanticheart.navigation.repository

import android.content.Context
import android.content.SharedPreferences
import com.quanticheart.navigation.extentions.clear
import com.quanticheart.navigation.extentions.getModel
import com.quanticheart.navigation.extentions.preferences
import com.quanticheart.navigation.extentions.setModel

class FormRepository(private val context: Context) {

    private val prefs: SharedPreferences by lazy { context.preferences }
    private val keyForm = "KEY_FORM"

    fun saveName(name: String) {
        val form = getForm()
        form.name = name
        form.save()
    }

    fun saveEmail(email: String) {
        val form = getForm()
        form.email = email
        form.save()
    }

    fun saveCel(cel: String) {
        val form = getForm()
        form.cel = cel
        form.save()
    }

    fun saveDoc(doc: String) {
        val form = getForm()
        form.doc = doc
        form.save()
    }

    fun sendRegister(): Boolean {
        prefs.clear(keyForm)
        return true
    }

    fun removeData() {
        prefs.clear(keyForm)
    }

    fun getForm(): FormRegister {
        return prefs.getModel(keyForm) ?: FormRegister()
    }

    private fun FormRegister.save() {
        prefs.setModel(keyForm, this)
    }
}