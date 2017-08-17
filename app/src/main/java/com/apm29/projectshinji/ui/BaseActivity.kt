package com.apm29.projectshinji.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apm29.projectshinji.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_layout)
    }

    fun init(title:String) {
        val actionBar = this.supportActionBar
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }
}
