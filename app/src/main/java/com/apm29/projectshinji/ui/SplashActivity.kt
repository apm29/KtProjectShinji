package com.apm29.projectshinji.ui

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import com.apm29.projectshinji.R
import org.jetbrains.anko.intentFor
import kotlin.concurrent.thread


/**
 * Created by apm29 on 2017/8/11.
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_layout)
        thread {
            SystemClock.sleep(1000)
            startActivity(intentFor<HomeActivity>().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()
        }
    }
}