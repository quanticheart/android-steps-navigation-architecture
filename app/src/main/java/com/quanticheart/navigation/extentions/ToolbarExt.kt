package com.quanticheart.navigation.extentions

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import com.quanticheart.navigation.R

fun Toolbar.setBackToolbar(action: () -> Unit) {
    val context = this.context as AppCompatActivity
    context.setSupportActionBar(this)
    context.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    context.supportActionBar?.setDisplayShowHomeEnabled(true)
    navigationIcon = AppCompatResources.getDrawable(context, R.drawable.ic_back)
    setNavigationOnClickListener {
        action()
    }
    title?.let {
        this.title = it
    }
}