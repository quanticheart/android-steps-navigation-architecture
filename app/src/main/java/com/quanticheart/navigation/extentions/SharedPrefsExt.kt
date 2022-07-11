package com.quanticheart.navigation.extentions

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

val Context.preferences: SharedPreferences
    get() = getSharedPreferences("APP", Context.MODE_PRIVATE)

fun SharedPreferences.getData(key: String) = this.getString(key, null)

fun SharedPreferences.setData(key: String, value: String) {
    val editor: SharedPreferences.Editor = edit()
    editor.putString(key, value)
    editor.apply()
}

inline fun <reified T> SharedPreferences.getModel(key: String): T? {
    return getData(key)?.let { json ->
        Gson().fromJson(json, object : TypeToken<T>() {}.type)
    } ?: run {
        null
    }
}

fun <T> SharedPreferences.setModel(key: String, data: T) {
    val json = Gson().toJson(data)
    setData(key, json)
}

fun SharedPreferences.clear(key: String) {
    edit().remove(key).apply()
}
